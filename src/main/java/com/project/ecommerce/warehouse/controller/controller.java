package com.project.ecommerce.warehouse.controller;

import com.project.ecommerce.warehouse.entity.Warehouse;
import com.project.ecommerce.warehouse.service.Warehouseservice;
import com.project.ecommerce.warehouse.service.Warehouseserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class controller {
    @Autowired
    private Warehouseserviceimpl warehouseserviceimpl;

    @PostMapping("/AddNewWarehouse")
    public Warehouse AddNewWarehouse(@RequestBody Warehouse warehouse){
        return this.warehouseserviceimpl.Addnewwarehouse(warehouse);

    }
    @GetMapping("/AllWarehouse")
    public List<Warehouse> GetAllWarehouse(){
        return this.warehouseserviceimpl.Getallwarehouse();
    }
}
