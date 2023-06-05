package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.warehouse.entity.Warehouse;

import java.util.List;

public interface Warehouseservice {

    public Warehouse addnewwarehouseimpl(Warehouse warehouse);

    public List<Warehouse> getallwarehouseimpl();

    public String getquantityimpl(Long id);

    public void deletewarehouseimpl(Long id);

    public String addstockimpl(Long id,Long stock);
}
