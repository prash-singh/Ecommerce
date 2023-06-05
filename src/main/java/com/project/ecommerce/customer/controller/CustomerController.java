package com.project.ecommerce.customer.controller;


import com.project.ecommerce.customer.entity.CustomerEntity;
import com.project.ecommerce.customer.service.CustomerServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServiceimpl customerService;
    @PostMapping("/signup")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity a){
        return a;
    }

}




