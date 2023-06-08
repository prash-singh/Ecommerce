package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getAllOrder(){
        return this.orderRepository.findAll();


    }

    public Order addOrder(Order o){
        this.orderRepository.save(o);
        return o;

    }
}
