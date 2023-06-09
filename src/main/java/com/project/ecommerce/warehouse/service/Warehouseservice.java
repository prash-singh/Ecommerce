package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.warehouse.entities.Shipment;
import com.project.ecommerce.warehouse.entities.Warehouse;

import java.util.List;

public interface Warehouseservice {

    public Warehouse addnewwarehouseimpl(Warehouse warehouse);

    public List<Warehouse> getallwarehouseimpl();

    public String getquantityimpl(Long id);

    public void deletewarehouseimpl(Long id);

    public String addstockimpl(String productid,Long stock);

    //update product
    //update warehouse stock
    public List<Shipment> getallshipment();

    public String Updateproduct(Order order);

    public String updateprofit(Order order);

    public String findwarehousefromproduct(String id);

    public String updateavailablequantity();

    public String addshipmenttoorder(Order order);

public Shipment addnewshipment(Shipment shipment);

public String getoverallprofit(Long warehouseId);




}
