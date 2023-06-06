package com.project.ecommerce.customer.service;

import com.project.ecommerce.customer.entity.AddressEntity;
import com.project.ecommerce.customer.entity.CustomerEntity;

import java.util.List;

public interface CustomerImplements{
String  addCustomer(CustomerEntity customer);
String  updateCustomer(CustomerEntity customer);
String  deleteCustomer(CustomerEntity customer);
CustomerEntity getCustomer(CustomerEntity customer);
CustomerEntity getCustomerById(CustomerEntity customer);

AddressEntity getAddress(AddressEntity  customer);
AddressEntity getAddressById(AddressEntity  customer);
AddressEntity updateAddress(AddressEntity customer);
AddressEntity deleteAddress(AddressEntity customer);


    public List<CustomerEntity> findAll();

    void deleteById(String id);

    void delete(CustomerEntity customerEntity);


}
