package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.entities.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder();
    public Order addOrder(Order o);
}
