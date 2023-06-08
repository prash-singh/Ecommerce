package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> getCart();
    public Cart getByUserId(String userId);
    public void addCart(CartDTO c);
    public void removeAllItems(String c);
}
