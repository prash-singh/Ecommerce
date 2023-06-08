package com.project.ecommerce.customer.service;

import com.project.ecommerce.customer.entities.AddressEntities;
import com.project.ecommerce.customer.entities.CustomerEntities;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CustomerImplements {
    String addCustomer(CustomerEntities customer);
    CustomerEntities getcustomerbyid(String id);

    CustomerEntities getCustomer(String email);

    CustomerEntities loginCustomer(CustomerEntities customer) throws Exception;
}
