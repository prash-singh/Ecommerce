package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.OrderDTO;
import com.project.ecommerce.orders.entities.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    public List<Order> getOrder(String customerId);
    public ResponseEntity placeOrder(OrderDTO o);
    public ResponseEntity returnOrder(String customerId, String orderId);
}
