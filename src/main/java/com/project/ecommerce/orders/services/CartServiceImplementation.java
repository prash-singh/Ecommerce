package com.project.ecommerce.orders.services;

import com.project.ecommerce.customer.repository.CustomerRepository;
import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.entities.CartItems;
import com.project.ecommerce.orders.repository.CartItemsRepository;
import com.project.ecommerce.orders.repository.CartRepository;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.products.services.ProductServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CartServiceImplementation implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductServices productServices;

    public Cart getByUserId(String userId){
        if (userId.isEmpty()){
            return null;
        }
        return this.cartRepository.getUserCart(userId);
    }

    public ResponseEntity<String> addCart(CartDTO c){
        if(c.getCustomerId().isEmpty()){
            return new ResponseEntity<>("CustomerId field cannot be Empty", HttpStatus.NOT_ACCEPTABLE);
        }else if(c.getProductId().isEmpty()){
            return new ResponseEntity<>("ProductId field cannot be Empty", HttpStatus.OK);
        }else if(c.getQuantity() < 1){
            return new ResponseEntity<>("Quantity cannot be negative or Zero",HttpStatus.OK);
        }


        String productId = c.getProductId();
        String userId = c.getCustomerId();
        try {
            if(this.customerRepository.findById(userId).get() == null){
                return new ResponseEntity<>("Invalid CustomerId",HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Invalid CustomerId",HttpStatus.OK);
        }
        Product p = this.productServices.getProduct(productId);
        if(p == null){
            log.error("Product not Found");
            return new ResponseEntity<>("Product not Found", HttpStatus.NO_CONTENT);
        }
        if(p.getAvailQuantity() == 0){
            return new ResponseEntity<>("This product is not Available",HttpStatus.OK);
        }

        if(c.getQuantity() > p.getAvailQuantity()){
            log.error("Quantity not available");
            return new ResponseEntity<>("Quantity not available please reduce quantity to proceed",HttpStatus.OK);
        }

        // update product quantity if product already exists in cart
        Cart cart = this.cartRepository.getUserCart(userId);
        if(cart != null) {
            List<CartItems> cItems = cart.getCartItems();
            List<CartItems> cItms = cart.getCartItems();
            long qty = 0;
            if (!cItms.isEmpty()){
                try {
                    qty = cItms.stream().filter(cartItems -> cartItems.getProductId().equals(productId)).collect(Collectors.toList()).get(0).getQuantity();
                }catch (Exception ignored){
                    // Adding new Items
                    long productQty = c.getQuantity();
                    CartItems cartItems = new CartItems();
                    cartItems.setProductId(productId);
                    cartItems.setQuantity(productQty);
                    cartItems.setPrice(productQty*p.getProductPrice()*1.0);
                    this.cartItemsRepository.save(cartItems);
                    Cart cr = this.cartRepository.getUserCart(userId);
                    if(cr == null){
                        cr = new Cart();
                        cr.setCustomerId(userId);
                        cr.setCartItems(new ArrayList<>());
                    }
                    cr.getCartItems().add(cartItems);
                    this.cartRepository.save(cr);
                    return new ResponseEntity<>("Added to cart", HttpStatus.ACCEPTED);
                }
                if(p.getAvailQuantity() == 0){
                    return new ResponseEntity<>("This product is not Available",HttpStatus.OK);
                }
                else if(c.getQuantity() + qty > p.getAvailQuantity()){
                    log.error("Quantity not available");
                    return new ResponseEntity<>("Quantity not available please reduce quantity to proceed",HttpStatus.OK);
                }
            }
            boolean flag = false;
            for (CartItems crt : cItems) {
                if (crt.getProductId().equals(productId)) {
                    crt.setQuantity(crt.getQuantity() + c.getQuantity());
                    crt.setPrice(crt.getQuantity() * p.getProductPrice() * 1.0);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                cart.setCartItems(cItems);
                this.cartRepository.save(cart);
                return new ResponseEntity<>("Quantity Updated",HttpStatus.OK);
            }
        }
        // Adding new Items
        long productQty = c.getQuantity();
        CartItems cartItems = new CartItems();
        cartItems.setProductId(productId);
        cartItems.setQuantity(productQty);
        cartItems.setPrice(productQty*p.getProductPrice()*1.0);
        this.cartItemsRepository.save(cartItems);
        Cart cr = this.cartRepository.getUserCart(userId);
        if(cr == null){
            cr = new Cart();
            cr.setCustomerId(userId);
            cr.setCartItems(new ArrayList<>());
        }
        cr.getCartItems().add(cartItems);
        this.cartRepository.save(cr);
        return new ResponseEntity<>("Added to cart", HttpStatus.ACCEPTED);
    }

    public ResponseEntity removeAllItems(String customerId){
        Cart c =this.cartRepository.getUserCart(customerId);
        if(c.getCartItems().isEmpty()){
            return new ResponseEntity("No item found",HttpStatus.NOT_FOUND);
        }
        c.setCartItems(new ArrayList<>());
        this.cartRepository.save(c);
        return new ResponseEntity<>("All Items Removed",HttpStatus.OK);
    }
}
