package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.exception.SHIPMENTEMPTYEXCEPTION;
import com.project.ecommerce.exception.WAREHOUSEEMPTYEXCEPTION;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.warehouse.entities.Shipment;
import com.project.ecommerce.warehouse.entities.Warehouse;

import java.util.List;

public interface Warehouseservice {

    public Warehouse addNewWarehouseImpl(Warehouse warehouse);

    public List<Warehouse> getAllWarehouseImpl() throws WAREHOUSEEMPTYEXCEPTION;

    public String getQuantityImpl(Long id);

    public void deleteWarehouseImpl(Long id) ;

    public String addStockImpl(String productid,Long stock);

    //update product
    //update warehouse stock
    public List<Shipment> getAllShipment() throws SHIPMENTEMPTYEXCEPTION;

    public String updateProduct(Order order);

    public String updateProfit(Order order);

    public String findWarehouseFromProduct(String id);

    public String updateAvailableQuantity();

    public String addShipmentToOrder(Order order);

public Shipment addNewShipment(Shipment shipment);

public String getOverallProfit(Long warehouseId);




}
