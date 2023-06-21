package com.project.ecommerce.warehouse.controller;
import com.project.ecommerce.Constants;
import com.project.ecommerce.exception.SHIPMENTEMPTYEXCEPTION;
import com.project.ecommerce.exception.WAREHOUSEEMPTYEXCEPTION;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.warehouse.entities.Shipment;
import com.project.ecommerce.warehouse.repository.Warehousedao;
import com.project.ecommerce.warehouse.entities.Warehouse;
import com.project.ecommerce.warehouse.service.Warehouseservice;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping(Constants.REQUEST_MAPPING)
@RestController
@Log4j2
public class Controller {


    @Autowired
    private Warehouseservice warehouseservice;

    @Autowired
    private Warehousedao warehousedao;

    @PostMapping(Constants.ADD_NEW_WAREHOUSE)
    public Warehouse addNewWarehouse(@RequestBody @Valid Warehouse warehouse) {
        return this.warehouseservice.addNewWarehouseImpl(warehouse);
    }

    @GetMapping(Constants.GET_ALL_PRODUCTS_IN_WAREHOUSE)
    public List<Product> getProductsInWarehouse(@PathVariable Long warehouseId) {
        Warehouse warehouse = warehousedao.findById(warehouseId).get();
        return warehouse.getProducts();
    }
    @GetMapping(Constants.GET_PROFIT_SELL_OF_WAREHOUSE)
    public String getProfitFromWarehouse(@PathVariable Long warehouseId){
        try {
            Warehouse warehouse= warehousedao.findById(warehouseId).get();
            return "the overall quantity sell from " + warehouse.getName() + " is " + warehouse.getTotalQuantitySell() + " and Total profit earn is " + warehouse.getOverallSellWarehouse();
        }
        catch(NoSuchElementException exc){
            throw new NoSuchElementException("Please enter valid warehouseId");
        }


    }


    @GetMapping(Constants.SHOW_ALL_WAREHOUSE)
    public List<Warehouse> getAllWarehouse() throws WAREHOUSEEMPTYEXCEPTION {
        return this.warehouseservice.getAllWarehouseImpl();
    }

    @GetMapping(Constants.GET_TOTAL_STOCK_OF_WAREHOUSE_BY_ID)
    public String getQuantity(@PathVariable String wareHouseId)  throws  NoSuchElementException {
        Long id = Long.parseLong(wareHouseId);
        return warehouseservice.getQuantityImpl(id);

    }

    @DeleteMapping(Constants.DELETE_WAREHOUSE_BY_ID)
    public String deleteWarehouse(@PathVariable String wareHouseId) throws NoSuchElementException {
        Long id = Long.parseLong(wareHouseId);
        this.warehouseservice.deleteWarehouseImpl(id);
        return "Done";
    }

    @PutMapping(Constants.ADD_STOCK_OF_PRODUCT)
    public String addStock(@PathVariable String productid ,@PathVariable Long stock) {
            return this.warehouseservice.addStockImpl(productid,stock);
        }


        @PutMapping(Constants.UPDATE_PRODUCT_AFTER_ORDER)
        public String updateProduct (@RequestBody Order order){

            return this.warehouseservice.updateProduct(order);

        }

    @PutMapping(Constants.UPDATE_PROFIT_OF_WAREHOUSES_AFTER_ORDER)
    public String updateProfit(@RequestBody Order order){

        return this.warehouseservice.updateProfit(order);
    }

    @GetMapping(Constants.FIND_WAREHOUSE_FROM_PRODUCT)
    public String findWarehouseFromProduct(@PathVariable String id){
                return this.warehouseservice.findWarehouseFromProduct(id);
    }
    @PutMapping(Constants.UPDATE_AVAILABLE_STOCK_FROM_WAREHOUSE_STOCK)
    public String updateAvailableQuantity(){
        return this.warehouseservice.updateAvailableQuantity();
    }

    @GetMapping(Constants.GET_ALL_SHIPMENT)
    public List<Shipment> getAllShipment() throws SHIPMENTEMPTYEXCEPTION {
        return this.warehouseservice.getAllShipment();
    }

    @PutMapping(Constants.SET_SHIPMENT_TO_ORDER)
    public String addShipmentToOrder(@RequestBody Order order) {
        return this.warehouseservice.addShipmentToOrder(order);
        }



    @PostMapping(Constants.ADD_NEW_SHIPMENT)
    public Shipment addNewShipment(@RequestBody @Valid Shipment shipment){
        return this.warehouseservice.addNewShipment(shipment);
    }

    @GetMapping(Constants.GET_OVERALL_PROFIT_OF_WAREHOUSE)
    public String getOverallProfitOfWarehouse(@PathVariable Long warehouseId){
        return this.warehouseservice.getOverallProfit(warehouseId);
    }

    @GetMapping(Constants.WAREHOUSE_WITH_MAXIMUM_PROFIT)
    public Warehouse warehouseWithMaximumSellProfit(){
        return warehousedao.warehousewithmaximumprofit();
    }


}