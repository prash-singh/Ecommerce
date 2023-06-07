package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.CartDTO;

public interface CartItemsService {
    public void deleteById(String userId, String id);

    public void updateQty(CartDTO uci);
}
