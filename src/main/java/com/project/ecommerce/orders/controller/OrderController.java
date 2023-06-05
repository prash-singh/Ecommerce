package com.project.ecommerce.orders.controller;

import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return this.orderService.getAllOrder();
    }

    @PostMapping("/orders")
    public Order addNewOrder(@RequestBody Order o){
        this.orderService.addOrder(o);
        return o;
    }
}
