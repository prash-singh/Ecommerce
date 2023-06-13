package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import org.springframework.http.ResponseEntity;


public interface CartService {
    public Cart getByUserId(String userId);
    public ResponseEntity<String> addCart(CartDTO c);
    public void removeAllItems(String c);
}
