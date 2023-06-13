package com.project.ecommerce.orders.services;

import org.springframework.http.ResponseEntity;

public interface CartItemsService {
    public ResponseEntity<Object> deleteById(String userId, String id);

    public ResponseEntity<String> updateQty(String cId,String pId, boolean opr);
}
