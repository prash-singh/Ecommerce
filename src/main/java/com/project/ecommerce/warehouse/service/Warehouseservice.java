package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.warehouse.entity.Warehouse;

import java.util.List;

public interface Warehouseservice {

    public Warehouse Addnewwarehouse(Warehouse warehouse);

    public List<Warehouse> Getallwarehouse();
}
