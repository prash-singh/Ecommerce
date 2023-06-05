package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService{

    private CartRepository cartRepository;
    public List<Cart> getCart(){
        return this.cartRepository.findAll();
    }
}
