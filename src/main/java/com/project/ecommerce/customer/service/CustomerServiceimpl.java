package com.project.ecommerce.customer.service;

import com.project.ecommerce.customer.entity.CustomerEntity;
import com.project.ecommerce.customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceimpl implements CustomerImplements{
    @Autowired
    private CustomerRepository customerRepository;
    public List<CustomerEntity> findAll(){
        return customerRepository.findAll();
    }

    public CustomerEntity findById(String id){
        return customerRepository.findById(id).get();
    }
    public CustomerEntity save(CustomerEntity customerEntity){
        return customerRepository.save(customerEntity);
    }
    public void deleteById(String id){
        customerRepository.deleteById(id);
    }

    public void delete(CustomerEntity customerEntity){
        customerRepository.delete(customerEntity);
    }

    public void deleteAll(){
        customerRepository.deleteAll();
    }

    public String addCustomer(CustomerEntity customer){

        return "wfds";
    }

    public String addCustomer(CustomerEntity customerEntity) {
        this.customerRepository.save(customerEntity);
        return "Added";
    }
}


























