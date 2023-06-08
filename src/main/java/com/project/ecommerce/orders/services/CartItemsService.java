package com.project.ecommerce.orders.services;

public interface CartItemsService {
    public void deleteById(String userId, String id);

    public void updateQty(String cId,String pId, boolean opr);
}
