package com.project.ecommerce.customer.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.customer.entities.CustomerEntities;
import com.project.ecommerce.customer.service.CustomerImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerImplements customerService;

    @PostMapping(Constants.SIGN_UP_BY_CUSTOMER)
    public String addCustomer(@RequestBody CustomerEntities customerEntities) {
        return this.customerService.addCustomer(customerEntities);
    }

    @PostMapping(Constants.SIGN_IN_BY_CUSTOMER)
    public String customerLogin(@RequestBody CustomerEntities customerEntities) throws Exception {
        try {
            this.customerService.loginCustomer(customerEntities);
            return "Login Successful \n Welcome Back";
        } catch (Exception e) {
            return "Incorrect EmailId or Password";
        }
    }

    @GetMapping(Constants.GET_CUSTOMER_BY_EmailID)
    public ResponseEntity<CustomerEntities> getCustomer(@PathVariable String emailId) {
        CustomerEntities list = this.customerService.getCustomer(emailId);
        if (list == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }
    @GetMapping(Constants.GET_ALL_CUSTOMER)
    public ResponseEntity<List<CustomerEntities>> getCustomer() {
        List<CustomerEntities> list = this.customerService.getAllCustomer();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @PutMapping(Constants.UPDATE_CUSTOMER_DETAILS)
    public CustomerEntities updateCustomerDetails(@PathVariable CustomerEntities customerEntities){
        return this.customerService.updateCustomer(customerEntities);
    }


}


