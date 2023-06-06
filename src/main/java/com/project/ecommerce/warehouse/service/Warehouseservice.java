package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.warehouse.entities.Warehouse;

import java.util.List;

public interface Warehouseservice {

    public Warehouse addnewwarehouseimpl(Warehouse warehouse);

    public List<Warehouse> getallwarehouseimpl();

    public String getquantityimpl(Long id);

    public void deletewarehouseimpl(Long id);

    public String addstockimpl(Long id,Long stock);

    //update product
    //update warehouse stock


    public Product Updateproduct(Order order);

    public String updateprofit(Order order);




}
