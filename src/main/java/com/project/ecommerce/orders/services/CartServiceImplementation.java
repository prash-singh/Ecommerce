package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.entities.CartItems;
import com.project.ecommerce.orders.repository.CartItemsRepository;
import com.project.ecommerce.orders.repository.CartRepository;
import com.project.ecommerce.products.entities.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CartServiceImplementation implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private RestTemplate restTemplate;
    public List<Cart> getCart(){
        try {
            return this.cartRepository.findAll();
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public Cart getByUserId(String userId){
        return this.cartRepository.getUserCart(userId);
    }

    public void addCart(CartDTO c){
        String productId = c.getProductId();
        String userId = c.getCustomerId();

        Product p = restTemplate.getForObject("http://localhost:8080/product/" + productId, Product.class);
        log.info(p);
        if(c.getQuantity() > p.getAvailQuantity()){
            log.error("Quantity not available");
        }
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
        log.info(cartRepository.findAll());
    }
}
