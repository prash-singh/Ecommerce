package com.project.ecommerce.warehouse.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.repository.OrderRepository;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.warehouse.repository.Warehousedao;
import com.project.ecommerce.warehouse.entities.Warehouse;
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

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/AddNewWarehouse")
    public Warehouse addNewWarehouse(@RequestBody Warehouse warehouse) {
        return this.warehouseservice.addnewwarehouseimpl(warehouse);
    }

    @GetMapping(Constants.SHOW_ALL_WAREHOUSE)
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

    @PutMapping("/updatewarehouse")
    public Product Updateproduct(@RequestBody Order order){
       return this.warehouseservice.Updateproduct(order);
    }
//    @PutMapping("/AddOrdertoShipment/")
//    public String AddOrdertoShipment(@RequestBody Order order ){
//        return this.warehouseservice.addordertoshipment(order);
//    }

    @PutMapping("/updateprofit")
    public String Updateprofit(@RequestBody Order order){

        return this.warehouseservice.updateprofit(order);

    }



}







