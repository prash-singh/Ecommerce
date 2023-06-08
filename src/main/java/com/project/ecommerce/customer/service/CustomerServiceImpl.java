package com.project.ecommerce.customer.service;

import com.project.ecommerce.customer.entities.AddressEntities;
import com.project.ecommerce.customer.entities.CustomerEntities;
import com.project.ecommerce.customer.repository.AddressRepository;
import com.project.ecommerce.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;

@Service
public  class CustomerServiceImpl implements CustomerImplements {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public String addCustomer(CustomerEntities customerEntity) {
        String emailId = customerEntity.getEmailId();
        CustomerEntities customerData = customerRepository.findByEmail(emailId);
        if (customerData != null) {
            return "Email Id already exists";
        }
        customerRepository.save(customerEntity);
        return "Customer Added Successfully";
    }

    @Override
    public CustomerEntities getcustomerbyid(String id) {
        return null;
    }

    @Override
    public CustomerEntities getCustomer(String emailId) {
        return this.customerRepository.findByEmail(emailId);
    }

    @Override
    public CustomerEntities loginCustomer(CustomerEntities customer) throws Exception {
        String emailId = customer.getEmailId();
        String password = customer.getPassword();
        CustomerEntities customerServiceimpl = customerRepository.findByEmailAndPassword(emailId, password);
        if (customerServiceimpl == null) {
            throw new Exception("Customer not found");
        } else {
            if (!customerServiceimpl.getPassword().equals(password)) {
                throw new Exception("Invalid  password");
            } else if (!customerServiceimpl.getEmailId().equals(emailId)) {
                throw new Exception("Invalid  Email");
            } else if (!customerServiceimpl.getEmailId().equals(emailId) && !customerServiceimpl.getPassword().equals(password)) {
                throw new Exception("Invalid  email and password");
            }
        }
        return customerServiceimpl;
    }


    public AddressEntities getCustomerAddress(String customerId) throws Exception {
        List<AddressEntities> address = (List<AddressEntities>) customerRepository.findById(customerId).get();
        if (address.isEmpty()) {
            throw new Exception("Customer not found");
        }
        if (address == null) {
            throw new Exception("Address of the customer not found");
        }
        return address.get(0);

    }

//    public List<AddressEntities> getCustomer(String customerId) {
//
//        if (customerId != null) {
//            CustomerEntities customer=customerRepository.findById(customerId).get();
//            List<AddressEntities> addressEntities= customer.getAddress();
//            return addressEntities;
//        }
//
//        return new ArrayList<>();
//    }


  public void deleteAddress(@PathVariable String customerId, @PathVariable String addressId) {
       customerRepository.deleteById(customerId);
       addressRepository.deleteById(addressId);
       System.out.println("Address delete Succesfully");
    }
public void updateAddress(@PathVariable String customerId){
        CustomerEntities customerEntities= customerRepository.findById(customerId).get();
        List<AddressEntities> addressEntities= customerEntities.getAddress();

        System.out.println("Address update Succesfully");
}
}

