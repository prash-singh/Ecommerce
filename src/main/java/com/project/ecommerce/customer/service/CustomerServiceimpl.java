package com.project.ecommerce.customer.service;

import com.project.ecommerce.warehouse.service.Warehouseservice;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl implements CustomerImplements{

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