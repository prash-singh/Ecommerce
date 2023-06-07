package com.project.ecommerce.customer.controller;

import com.project.ecommerce.customer.entities.CustomerEntities;
import com.project.ecommerce.customer.service.CustomerImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerImplements customerService;

    @PostMapping("/signup")
    public String addCustomer(@RequestBody CustomerEntities customerEntities) {
        return this.customerService.addCustomer(customerEntities);
    }

    @GetMapping("/login")
    public CustomerEntities findAllCustomer(@RequestBody CustomerEntities a) {
        return a;
    }

    @GetMapping("/customer")
    public List<CustomerEntities> findAllCustomer() {
        return new ArrayList<>();
    }

    @PutMapping("/customer")
    public List<CustomerEntities> updateCustomer(@RequestBody CustomerEntities a) {
        return new ArrayList<>();
    }

    @GetMapping("/customer/{id}")
    public CustomerEntities findCustomerById(@PathVariable("id") int id) {
        return new CustomerEntities();
    }

    @GetMapping("/address/{id}")
    public CustomerEntities findAddressById(@PathVariable("id") int id) {
        return new CustomerEntities();
    }

    @GetMapping("/address")
    public List<CustomerEntities> findAddress() {
        return new ArrayList<>();
    }

    @PutMapping("/address")
    public List<CustomerEntities> updateAddress(@RequestBody CustomerEntities a) {
        return new ArrayList<>();
    }

    @DeleteMapping("/address/{id}")
    public List<CustomerEntities> deleteAddress(@PathVariable("id") int id) {
        return new ArrayList<>();
    }

    @PostMapping("/address")
    public List<CustomerEntities> addAddress(@RequestBody CustomerEntities a) {
        return new ArrayList<>();
    }
    @DeleteMapping("/address")
    public List<CustomerEntities> deleteAddress(@RequestBody CustomerEntities a) {
        return new ArrayList<>();
    }
}

