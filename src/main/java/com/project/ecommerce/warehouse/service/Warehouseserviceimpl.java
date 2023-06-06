package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.orders.controller.OrderController;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.entities.OrderItems;
import com.project.ecommerce.orders.repository.OrderRepository;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.products.repositiry.ProductRepo;
import com.project.ecommerce.warehouse.repository.Warehousedao;
import com.project.ecommerce.warehouse.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class Warehouseserviceimpl implements Warehouseservice {
    @Autowired
    private Warehousedao warehousedao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderController orderController;

    @Autowired
    private ProductRepo productdao;


    @Autowired
    private OrderRepository orderRepository;

    public Warehouse addnewwarehouseimpl(Warehouse warehouse) {
        return warehousedao.save(warehouse);
    }

    public List<Warehouse> getallwarehouseimpl() {
        return this.warehousedao.findAll();
    }

    public String getquantityimpl(Long id) {
        Warehouse warehouse = warehousedao.findById(id).get();
        return "The Quantity at " + warehouse.getLocation() + " Warehouse is " + warehouse.getAvailablestock();

    }

    public void deletewarehouseimpl(Long id) {
        warehousedao.delete(warehousedao.findById(id).get());
    }

    public String addstockimpl(Long id, Long stock) {
        Warehouse warehouse = warehousedao.findById(id).get();
        Long available = warehouse.getWarehousecapacity() - warehouse.getAvailablestock();

        if (stock <= available) {
            warehouse.setAvailablestock(warehouse.getAvailablestock() + stock);
            warehousedao.save(warehouse);
            return "the avilable stock at " + warehouse.getName() + "warehouse is " + warehouse.getAvailablestock();
        }
        return "Sufficient space not avilable in " + warehouse.getName() + " warehouse";
    }

    public Product Updateproduct(Order order) {

        List<OrderItems> orderItems = order.getOrderItems();


        long total = 0;
        for (OrderItems item : orderItems) {
            Product p = restTemplate.getForObject("http://localhost:8080/product/" + item.getProductItemId(), Product.class);
            double price = (item.getPrice() * (double) item.getQuantity());
            if (item.getQuantity() <= p.getAvailQuantity()) {
                p.setAvailQuantity(p.getAvailQuantity() - item.getQuantity());
                p.setWarehouseStock(p.getWarehouseStock() - item.getQuantity());
                productdao.save(p);

                List<Warehouse> warehouses = Collections.singletonList(restTemplate.getForObject("http://localhost:8080/AllWarehouse", Warehouse.class));
                for (Warehouse warehouse : warehouses) {
                    List<Product> product = warehouse.getProducts();
                    for (Product product1 : product) {
                        if (product1.getId() == p.getId()) {
                            warehouse.setAvailablestock(warehouse.getAvailablestock() - item.getQuantity());

                            warehousedao.save(warehouse);
                            break;
                        }
                    }

                }
            }
        }
        return new Product();
    }

    public String updateprofit(Order order) {
        List<OrderItems> orderItems = order.getOrderItems();
        for (OrderItems items : orderItems) {
            String product_Id = items.getProductItemId();
            List<Warehouse> warehouses = warehousedao.findAll();
            for (Warehouse warehouse : warehouses) {
                List<Product> products = productdao.findAll();
                for (Product product : products) {
                    if (product.getId() == product_Id) {
                        warehouse.setOverall_sell_warehouse(warehouse.getOverall_sell_warehouse() + (items.getPrice() * items.getQuantity()));
                        warehousedao.save(warehouse);
                        break;
                    }
                }
            }
        }

        return "Sell value updated";
    }
}








