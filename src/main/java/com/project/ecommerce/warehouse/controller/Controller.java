package com.project.ecommerce.warehouse.controller;

import com.project.ecommerce.warehouse.dao.Warehousedao;
import com.project.ecommerce.warehouse.entity.Warehouse;
import com.project.ecommerce.warehouse.service.Warehouseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Warehouseservice warehouseservice;

    @Autowired
    private Warehousedao warehousedao;

    @PostMapping("/AddNewWarehouse")
    public Warehouse addNewWarehouse(@RequestBody Warehouse warehouse) {
        return this.warehouseservice.addnewwarehouseimpl(warehouse);
    }

    @GetMapping("/AllWarehouse")
    public List<Warehouse> getAllWarehouse() {
        return this.warehouseservice.getallwarehouseimpl();
    }

    @GetMapping("/GetQuantity/{wareHouseId}")
    public String getQuantity(@PathVariable String wareHouseId) {
        Long id = Long.parseLong(wareHouseId);
        return warehouseservice.getquantityimpl(id);

    }

    @DeleteMapping("/DeleteWarehouse/{wareHouseId}")
    public String deleteWarehouse(@PathVariable String wareHouseId) {
        Long id = Long.parseLong(wareHouseId);
        this.warehouseservice.deletewarehouseimpl(id);
        return "Done";
    }

    @PutMapping("/AddStock/{wareHouseId}")
    public String addStock(@PathVariable String wareHouseId, @RequestParam Long stock) {
        return this.warehouseservice.addstockimpl(Long.parseLong(wareHouseId),stock);
    }
}





