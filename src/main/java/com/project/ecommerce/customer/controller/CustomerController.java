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
    public String addCustomer(@RequestBody CustomerEntity customerEntity ) {
        return customerService.addCustomer(customerEntity);
    }

    @Autowired
    private CustomerServiceimpl CustomerService;
    @GetMapping("/login")
    public CustomerEntity findAllCustomer(@RequestBody CustomerEntity a)
    {
        return a;
    }
    @PutMapping("/update")
    public CustomerEntity getCustomer(@RequestBody CustomerEntity a)
    {
        return a;
    }
    @DeleteMapping("/delete")
    public CustomerEntity deleteCustomer (@RequestBody CustomerEntity a)
    {
        return  a;
    }
    @GetMapping ("/customer")
    public List<CustomerEntity> findallCustomers(@RequestBody CustomerEntity a)
    {
        return  new ArrayList<CustomerEntity>();
    }


}
