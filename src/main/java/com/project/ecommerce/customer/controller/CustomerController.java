package com.project.ecommerce.customer.controller;

import com.project.ecommerce.customer.entities.CustomerEntities;
import com.project.ecommerce.customer.service.CustomerImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerImplements customerService;

    @PostMapping("/signup")
    public String addCustomer(@RequestBody CustomerEntities customerEntities) {
        return this.customerService.addCustomer(customerEntities);
    }

    @PostMapping("/login")
    public CustomerEntities customerLogin(@RequestBody CustomerEntities customerEntities) throws Exception {
        try{
            return this.customerService.loginCustomer(customerEntities);
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/customer/{emailId}")
    public CustomerEntities getCustomer(@PathVariable String emailId) {
        return this.customerService.getCustomer(emailId);
    }

}

