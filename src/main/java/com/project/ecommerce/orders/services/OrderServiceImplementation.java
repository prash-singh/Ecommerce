package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService{

    private OrderRepository orderRepository;
    public List<Order> getAllOrder(){
        try{
            return this.orderRepository.findAll();
        }catch (Exception e){
            return new ArrayList<>();
        }


    }

    public Order addOrder(Order o){
        this.orderRepository.save(o);
        return o;
    }
}
