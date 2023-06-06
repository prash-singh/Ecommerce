package com.project.ecommerce.customer.controller;


import com.project.ecommerce.customer.entity.CustomerEntity;
import com.project.ecommerce.customer.service.CustomerServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServiceimpl customerService;

    @PostMapping("/signup")
    public String addCustomer(@RequestBody CustomerEntity customerEntity)
    {
        return customerService.addCustomer(customerEntity);
    }

    @Autowired
    private CustomerServiceimpl customerServiceimpl;

    @GetMapping("/login")
    public CustomerEntity findAllCustomer(@RequestBody CustomerEntity a) {
        return a;
    }

    @GetMapping("/customer")
    public List<CustomerEntity> findAllCustomer() {
        return new ArrayList<>();
    }

    @GetMapping("/customer/{id}")
    public CustomerEntity findCustomerById(@PathVariable("id") int id) {
        return new CustomerEntity();

    }
    @GetMapping("/address/{id}")
    public CustomerEntity findAddressById(@PathVariable("id") int id) {
        return new CustomerEntity();
    }
    @GetMapping("/address")
    public List<CustomerEntity> findAddress() {
        return new ArrayList<>();
    }
    @PutMapping("/address")
    public List<CustomerEntity> updateAddress(@RequestBody CustomerEntity a) {
        return new ArrayList<>();
    }
    @DeleteMapping("/address/{id}")
    public List<CustomerEntity> deleteAddress(@PathVariable("id") int id) {
        return new ArrayList<>();
    }
    @PostMapping("/address")
    public List<CustomerEntity> addAddress(@RequestBody CustomerEntity a) {
        return new ArrayList<>();
    }
    @PutMapping("/customer")
    public List<CustomerEntity> updateCustomer(@RequestBody CustomerEntity a) {
        return new ArrayList<>();
    }

}

