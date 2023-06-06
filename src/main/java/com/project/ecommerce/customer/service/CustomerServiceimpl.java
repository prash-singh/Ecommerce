package com.project.ecommerce.customer.service;

import com.project.ecommerce.customer.entities.CustomerEntities;
import com.project.ecommerce.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerServiceimpl implements CustomerImplements{
    @Autowired
    private CustomerRepository customerRepository;
    public List<CustomerEntities> findAll() { return customerRepository.findAll();
    }
    public CustomerEntities findById(String id){
        return customerRepository.findById(id).get();
    }
    public CustomerEntities save(CustomerEntities customerEntity){
        return customerRepository.save(customerEntity);
    }
    public void deleteById(String id){
        customerRepository.deleteById(id);
    }

    public void delete(CustomerEntities customerEntity){
        customerRepository.delete(customerEntity);
    }

    public void deleteAll(){
        customerRepository.deleteAll();
    }

    public String addCustomer(CustomerEntity customer){

        return "wfds";
    }

    public String addCustomer(CustomerEntities customerEntity) {
        this.customerRepository.save(customerEntity);
        return "Added";
    }
}


























