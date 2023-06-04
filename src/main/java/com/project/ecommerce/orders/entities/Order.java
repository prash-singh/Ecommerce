package com.project.ecommerce.orders.entities;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Order {
    @GetMapping("/orders")
    public String orders(){
        return "Orders";
    }
}
