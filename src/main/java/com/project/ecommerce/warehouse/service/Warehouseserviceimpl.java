package com.project.ecommerce.warehouse.service;

import com.project.ecommerce.customer.entities.AddressEntities;
import com.project.ecommerce.customer.repository.AddressRepository;
import com.project.ecommerce.customer.repository.CustomerRepository;
import com.project.ecommerce.exception.SHIPMENTEMPTYEXCEPTION;
import com.project.ecommerce.exception.WAREHOUSEEMPTYEXCEPTION;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.entities.OrderItems;
import com.project.ecommerce.orders.repository.OrderRepository;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.products.repository.ProductRepo;
import com.project.ecommerce.warehouse.entities.Shipment;
import com.project.ecommerce.warehouse.repository.Shipmentdao;
import com.project.ecommerce.warehouse.repository.Warehousedao;
import com.project.ecommerce.warehouse.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class Warehouseserviceimpl implements Warehouseservice {
    @Autowired
    private Warehousedao warehousedao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;



    @Autowired
    private ProductRepo productdao;

    @Autowired
    private Shipmentdao shipmentdao;


    @Autowired
    private OrderRepository orderRepository;

    public Warehouse addnewwarehouseimpl(Warehouse warehouse) {
        return warehousedao.save(warehouse);
    }

    public List<Warehouse> getallwarehouseimpl() throws WAREHOUSEEMPTYEXCEPTION {
        List<Warehouse> warehouses=warehousedao.findAll();
        if(warehouses.size()!=0) {return warehouses;}
        else {throw new WAREHOUSEEMPTYEXCEPTION("warehouse is empty");}

    }

    public String getquantityimpl(Long id) {
        Warehouse warehouse = warehousedao.findById(id).get();
        long stock= warehouse.getAvailableStock();

        return "The Quantity at " + warehouse.getLocation() + " Warehouse is " + warehouse.getAvailableStock();

    }

    public void deletewarehouseimpl(Long id) {
       Warehouse warehouse= warehousedao.findById(id).get();
       if(warehouse!=null){
           warehousedao.delete(warehouse);
       }
       else {
           throw new NoSuchElementException("warehouse not found at id"+id);
       }
    }

    public String addstockimpl(String productid, Long stock)
    {
        List<Product> products = productdao.findAll();
        for (Product product1 : products)
        {
            if (product1.getId().equals(productid))
            {

                String warehouseid = findwarehousefromproduct(productid);
                Long id = Long.parseLong(warehouseid);
                Product product = productdao.findById(productid).get();

                Warehouse warehouse = warehousedao.findById(id).get();


                if ((warehouse.getWarehouseCapacity() - warehouse.getAvailableStock()) < stock)
                    return "no space available";

                Long updated_stock = product.getWarehouseStock() + stock;
                Long updated_warehouse_stock = warehouse.getAvailableStock() + stock;
                product.setWarehouseStock(updated_stock);
                warehouse.setAvailableStock(updated_warehouse_stock);
                productdao.save(product);
                warehousedao.save(warehouse);

                return "done";
            }

        }
        return "product not available with id ,please add new product with whole description";
    }

    public String Updateproduct(Order order) {
        List<OrderItems> items=order.getOrderItems();
        //List<Warehouse> warehouses = warehousedao.findAll();
        for(OrderItems item : items) {
            String id = item.getProductItemId();
            Product p = restTemplate.getForObject("http://localhost:8080/product/" + id, Product.class);
            if(p.getAvailQuantity()<item.getQuantity()){
                return " Ordered quantity not availale remove the item to proceed";
            }
            p.setAvailQuantity(p.getAvailQuantity() - item.getQuantity());
            p.setWarehouseStock(p.getWarehouseStock() - item.getQuantity());
            String warehouseid=findwarehousefromproduct(id);
            Warehouse warehouse= warehousedao.findById(Long.parseLong(warehouseid)).get();
            warehouse.setTotalQuantitySell(warehouse.getTotalQuantitySell()+item.getQuantity());
            warehouse.setOverallSellWarehouse(warehouse.getOverallSellWarehouse()+item.getPrice());
            warehouse.setAvailableStock(warehouse.getAvailableStock()-item.getQuantity());
            productdao.save(p);
            warehousedao.save(warehouse);


        }
        return "Order done from warehouse side";

    }

    public String  updateprofit(Order order) {
        List<OrderItems> orderItems=order.getOrderItems();
        for(OrderItems item : orderItems){
            String warehouse_id=findwarehousefromproduct(item.getProductItemId());
            Warehouse warehouse = warehousedao.findById(Long.parseLong(warehouse_id)).get();
            warehouse.setOverallSellWarehouse(warehouse.getOverallSellWarehouse()+item.getPrice());
            warehousedao.save(warehouse);

        }

        return "profit updated";
    }

    public String findwarehousefromproduct(String id){
        List<Warehouse> warehouses=warehousedao.findAll();

        for(Warehouse warehouse : warehouses) {
            List<Product> products = warehouse.getProducts();
            for(Product product : products){
                String d=product.getId();
                if(id.equals(d)) {
                    String warehouse1=Long.toString(warehouse.getWareHouseId());
                    return warehouse1;
                }

            }
        }
        return " product not available in any warehouse";
    }

    public String updateavailablequantity(){

        List<Product> products=productdao.findAll();
        for(Product product : products){
            if(product.getAvailQuantity()<1201){
                product.setAvailQuantity(product.getAvailQuantity()+30);
                product.setWarehouseStock(product.getWarehouseStock()-30);
                productdao.save(product);
            }
        }
        return "Stock updated";
    }

    @Override
    public List<Shipment> getallshipment() throws SHIPMENTEMPTYEXCEPTION {
        List<Shipment> shipmentList=shipmentdao.findAll();
        if(shipmentList.size()!=0) return shipmentList;
        else throw new SHIPMENTEMPTYEXCEPTION("NO SHIPMENT SCHEDULE");
    }

    public String addshipmenttoorder(Order order){
        String Addresid = order.getShippingAddress();
        AddressEntities addressEntities = addressRepository.findById(Addresid).get();
        String postal_code = addressEntities.getPostalCode();
        List<Shipment> shipmentList = shipmentdao.findAll();
        for (Shipment shipment : shipmentList) {
            String destination=Long.toString(shipment.getDestinationWarehouseId());
            if(postal_code.equals(destination)){

                List<Order> orders=shipment.getOrders();
                orders.add(order);
                shipment.setOrders(orders);
                shipmentdao.save(shipment);
                return "order added to shipment";
            }
            else{
                //addnewshipmentbyorder(order,postal_code);
                return "order added to new shipment";
            }
        }
        return "no shipment schedule for given destination address";

    }
    public Shipment addnewshipment(Shipment shipment){
       return  shipmentdao.save(shipment);
    }

    public void addnewshipmentbyorder(Order order,String postal_code){
        Shipment shipment=new Shipment();
        List<OrderItems> items = order.getOrderItems();
        OrderItems item =items.get(1);
        String warehouse_id=findwarehousefromproduct(item.getProductItemId());
        shipment.setDestinationWarehouseId(Long.parseLong(postal_code));
        shipment.setOriginwareHouseId(Long.parseLong(warehouse_id));
        shipmentdao.save(shipment);

    }
    public String getoverallprofit(Long warehouseId){
        Warehouse warehouse= warehousedao.findById(warehouseId).get();

        return "The overall sell from " + warehouse.getName() + " is of Rs. "+ warehouse.getOverallSellWarehouse() + " and total quantity sold from " + warehouse.getName() + " is "+ warehouse.getTotalQuantitySell();
    }
}








