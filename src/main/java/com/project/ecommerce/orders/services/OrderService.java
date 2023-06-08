package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.OrderDTO;
import com.project.ecommerce.orders.entities.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getOrder(String customerId);
    public String placeOrder(OrderDTO o);
    public String returnOrder(String customerId, String orderId);
}
