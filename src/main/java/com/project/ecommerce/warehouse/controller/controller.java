package com.project.ecommerce.warehouse.controller;

import com.project.ecommerce.warehouse.dao.Warehousedao;
import com.project.ecommerce.warehouse.entity.Warehouse;
import com.project.ecommerce.warehouse.service.Warehouseservice;
import com.project.ecommerce.warehouse.service.Warehouseserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {
    @Autowired
    private Warehouseservice warehouseservice;

    @Autowired
    private Warehousedao warehousedao;

    @PostMapping("/AddNewWarehouse")
    public Warehouse AddNewWarehouse(@RequestBody Warehouse warehouse){
        return this.warehouseservice.Addnewwarehouse(warehouse);
    }
    @GetMapping("/AllWarehouse")
    public List<Warehouse> GetAllWarehouse(){
        return this.warehouseservice.Getallwarehouse();
    }
    @GetMapping("/GetQuantity/{wareHouseId}")
    public String GetQuantity(@PathVariable String wareHouseId){
        Long id= Long.parseLong(wareHouseId);
        return warehouseservice.Getquantity(id);

    }

    @DeleteMapping("/DeleteWarehouse/{wareHouseId}")
    public String DeleteWarehouse(@PathVariable String wareHouseId){
        Long id= Long.parseLong(wareHouseId);
        this.warehouseservice.Deletewarehouse(id);
        return "Done";
    }




}
