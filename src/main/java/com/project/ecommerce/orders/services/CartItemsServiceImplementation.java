package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.entities.CartItems;
import com.project.ecommerce.orders.repository.CartItemsRepository;
import com.project.ecommerce.orders.repository.CartRepository;
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

    public ResponseEntity<Object> deleteById(String userId, String cartId){
        if(userId.isEmpty()){
            return new ResponseEntity<>("CustomerId cannot Be Empty", HttpStatus.NOT_ACCEPTABLE);
        }

        if(cartId.isEmpty()){
            return new ResponseEntity<>("CartId Cannot be Empty",HttpStatus.NOT_ACCEPTABLE);
        }

        Cart c = this.cartRepository.getUserCart(userId);

        if(c == null){
            return new ResponseEntity<>("Invalid CustomerId",HttpStatus.NOT_ACCEPTABLE);
        }

        List<CartItems> cartItems = c.getCartItems();
        cartItems = cartItems.stream().filter(cart -> !cart.getId().equals(cartId)).collect(Collectors.toList());
        if(cartItems == null){
            return new ResponseEntity<>("Invalid CartId",HttpStatus.NOT_ACCEPTABLE);
        }
        c.setCartItems(cartItems);
        this.cartRepository.save(c);
        this.cartItemsRepository.deleteById(cartId);
        return new ResponseEntity<>("Item Deleted",HttpStatus.OK);
    }

    public ResponseEntity<String> updateQty(String cId, String pId, boolean opr){
        if(cId.isEmpty()){
            return new ResponseEntity<>("CustomerId cannot be empty",HttpStatus.NOT_ACCEPTABLE);
        }

        if(pId.isEmpty()){
            return new ResponseEntity<>("ProductId cannot be empty",HttpStatus.NOT_ACCEPTABLE);
        }
        Cart crt = this.cartRepository.getUserCart(cId);
        if(crt == null){
            return new ResponseEntity<>("Invalid CustomerId",HttpStatus.NOT_ACCEPTABLE);
        }
        List<CartItems> c = crt.getCartItems();
        if(c.isEmpty()){
            return new ResponseEntity<>("Cart is Empty",HttpStatus.OK);
        }
        boolean flag = true;

        for (CartItems cart: c) {
            if(cart.getProductId().equals(pId)){
                if (opr) {
                    cart.setQuantity(cart.getQuantity()+1);

                } else {
                    cart.setQuantity(cart.getQuantity()-1);
                }
                flag = false;
            }
        }
        if(flag){
            return new ResponseEntity<>("Invalid ProductId",HttpStatus.NOT_ACCEPTABLE);
        }
        crt.setCartItems(c);
        this.cartRepository.save(crt);
        return new ResponseEntity<>("Item Updated",HttpStatus.OK);
    }
}
