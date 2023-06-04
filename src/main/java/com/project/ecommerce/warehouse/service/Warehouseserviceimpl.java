package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.warehouse.dao.Warehousedao;
import com.project.ecommerce.warehouse.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Warehouseserviceimpl implements Warehouseservice{
    @Autowired
    private Warehousedao warehousedao;
    public Warehouse Addnewwarehouse(Warehouse warehouse){
        return warehousedao.save(warehouse);
    }

    public List<Warehouse> Getallwarehouse(){
        return this.warehousedao.findAll();
    }

    public String Getquantity(Long id){
        Warehouse warehouse= warehousedao.findById(id).get();
        String ans="The Quantity at " + warehouse.getLocation()+" Warehouse is "+ warehouse.getAvailablestock();
        return ans;
    }

    public void Deletewarehouse(Long id){
        warehousedao.delete(warehousedao.findById(id).get());
    }
}
