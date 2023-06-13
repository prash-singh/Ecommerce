package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.entities.CartItems;
import com.project.ecommerce.orders.repository.CartItemsRepository;
import com.project.ecommerce.orders.repository.CartRepository;
import com.project.ecommerce.products.services.ProductServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CartItemsServiceImplementation implements CartItemsService{

    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductServices productServices;

    public ResponseEntity<Object> deleteById(String userId, String cartId){
        if(userId.isEmpty()){
            return new ResponseEntity<>("CustomerId cannot Be Empty", HttpStatus.OK);
        }

        if(cartId.isEmpty()){
            return new ResponseEntity<>("CartId Cannot be Empty",HttpStatus.OK);
        }

        Cart c = this.cartRepository.getUserCart(userId);

        if(c == null){
            return new ResponseEntity<>("Invalid CustomerId",HttpStatus.OK);
        }

        List<CartItems> cartItems = c.getCartItems();
        cartItems = cartItems.stream().filter(cart -> !cart.getId().equals(cartId)).collect(Collectors.toList());
        if(cartItems == null){
            return new ResponseEntity<>("Invalid CartId",HttpStatus.OK);
        }
        c.setCartItems(cartItems);
        this.cartRepository.save(c);
        this.cartItemsRepository.deleteById(cartId);
        return new ResponseEntity<>("Item Deleted",HttpStatus.OK);
    }

    public ResponseEntity<String> updateQty(String cId, String pId, boolean opr){
        if(cId.isEmpty()){
            return new ResponseEntity<>("CustomerId cannot be empty",HttpStatus.OK);
        }

        if(pId.isEmpty()){
            return new ResponseEntity<>("ProductId cannot be empty",HttpStatus.OK);
        }
        Cart crt = this.cartRepository.getUserCart(cId);
        if(crt == null){
            return new ResponseEntity<>("Invalid CustomerId",HttpStatus.OK);
        }
        List<CartItems> c = crt.getCartItems();
        if(c.isEmpty()){
            return new ResponseEntity<>("Cart is Empty",HttpStatus.OK);
        }
        boolean flag = true;

        for (CartItems cart: c) {
            if(cart.getProductId().equals(pId)){
                if(cart.getQuantity() >= this.productServices.getProduct(pId).getAvailQuantity()){
                    return new ResponseEntity<>("Quantity not available",HttpStatus.OK);
                }
                if (opr) {
                    cart.setQuantity(cart.getQuantity()+1);
                } else {
                    cart.setQuantity(cart.getQuantity()-1);
                }
                flag = false;
            }
        }
        if(flag){
            return new ResponseEntity<>("Invalid ProductId",HttpStatus.OK);
        }
        crt.setCartItems(c);
        this.cartRepository.save(crt);
        return new ResponseEntity<>("Item Updated",HttpStatus.OK);
    }
}
