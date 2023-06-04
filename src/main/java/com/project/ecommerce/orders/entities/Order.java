package com.project.ecommerce.orders.entities;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Order {
    @GetMapping("/orders")
    public String orders(){
        return "Orders";
    }

    @GetMapping("/orders/{id}")
    public String getById(@PathVariable String id){
        return id;
    }
}
