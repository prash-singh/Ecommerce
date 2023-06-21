package com.project.ecommerce.customer.service;


import com.project.ecommerce.customer.entities.AddressEntities;
import com.project.ecommerce.customer.entities.CustomerEntities;


import java.util.List;
public interface CustomerImplements {
    String addCustomer(CustomerEntities customer);
    CustomerEntities getCustomer(String email);
    List<CustomerEntities> getAllCustomer();
    CustomerEntities updateCustomer(CustomerEntities customer);
    CustomerEntities loginCustomer(String emailId,String password) throws Exception;
    List<AddressEntities> getCustomerAddress(String customerId) throws Exception;

}
