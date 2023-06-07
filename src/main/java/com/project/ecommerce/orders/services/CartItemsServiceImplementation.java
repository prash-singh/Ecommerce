package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.entities.CartItems;
import com.project.ecommerce.orders.repository.CartItemsRepository;
import com.project.ecommerce.orders.repository.CartRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void deleteById(String userId, String cartId){
        Cart c = this.cartRepository.getUserCart(userId);
        List<CartItems> cartItems = c.getCartItems();
        cartItems = cartItems.stream().filter(cart -> !cart.getId().equals(cartId)).collect(Collectors.toList());
        c.setCartItems(cartItems);
        this.cartRepository.save(c);
        this.cartItemsRepository.deleteById(cartId);
    }

    public void updateQty(CartDTO c){

    }
}
