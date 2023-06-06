package com.project.ecommerce.customer.service;

import com.project.ecommerce.customer.entity.CustomerEntity;
import com.project.ecommerce.customer.repo.CustomerRepository;
import com.project.ecommerce.warehouse.service.Warehouseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl implements CustomerImplements{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String addCustomer(CustomerEntity customer) {

        try{
            customerRepository.save(customer);
        }
        catch(Exception e){
            System.out.println(e.getMessage().toString());
            return new String("failed");
        }
        return new String("success");


//        CustomerEntity customerData  = new CustomerEntity();
//        String username=customer.getUsername();
//        String emailId = customer.getEmailId();
//        String password = customer.getPassword();
    }
}




































//public class Warehouseserviceimpl implements Warehouseservice{
//    @Autowired
//    private Warehousedao warehousedao;
//    public Warehouse addnewwarehouseimpl(Warehouse warehouse){
//        return warehousedao.save(warehouse);
//    }
//
//    public List<Warehouse> getallwarehouseimpl(){
//        return this.warehousedao.findAll();
//    }
//
//    public String getquantityimpl(Long id){
//        Warehouse warehouse= warehousedao.findById(id).get();
//        return "The Quantity at " + warehouse.getLocation()+" Warehouse is "+ warehouse.getAvailablestock();
//
//    }
//
//    public void deletewarehouseimpl(Long id){
//        warehousedao.delete(warehousedao.findById(id).get());
//    }
//
//    public String addstockimpl(Long id,Long stock){
//        Warehouse warehouse= warehousedao.findById(id).get();
//        Long available= warehouse.getWarehousecapacity()-warehouse.getAvailablestock();
//
//        if(stock<=available){
//            warehouse.setAvailablestock(warehouse.getAvailablestock()+stock);
//            warehousedao.save(warehouse);
//            return "the avilable stock at " + warehouse.getName() + "warehouse is " + warehouse.getAvailablestock();
//        }
//        return "Sufficient space not avilable in " + warehouse.getName()+ " warehouse";
//
//
//
//
//    }