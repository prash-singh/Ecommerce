package com.project.ecommerce.orders.services;

import com.project.ecommerce.orders.dto.OrderDTO;
import com.project.ecommerce.orders.entities.CartItems;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.entities.OrderItems;
import com.project.ecommerce.orders.repository.OrderItemsRepository;
import com.project.ecommerce.orders.repository.OrderRepository;
import com.project.ecommerce.warehouse.service.Warehouseservice;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class OrderServiceImplementation implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private Warehouseservice warehouseservice;

    public List<Order> getOrder(String customerId){
        return this.orderRepository.findOrderByCustomerId(customerId);
    }

    public ResponseEntity placeOrder(OrderDTO ord){
        Order o = new Order();
        o.setOrderStatus(true);
        o.setDate((new Timestamp(new Date().getTime())).toString());
        o.setShippingAddress(ord.getShippingAddressId());
        o.setCustomerId(ord.getCustomerId());
        o.setOrderItems(new ArrayList<>());
        List<CartItems> cartItems;
        try {
            cartItems = this.cartService.getByUserId(ord.getCustomerId()).getCartItems();
        }catch (Exception e){
            return new ResponseEntity("Error no item found in Cart", HttpStatus.NOT_FOUND);
        }
        if(cartItems == null || cartItems.isEmpty()){
            log.info("Error no item found in Cart");
            return new ResponseEntity("Error no item found in Cart", HttpStatus.NOT_FOUND);
        }
        double total = 0;
        for (CartItems c: cartItems) {
            OrderItems orderItems = new OrderItems();
            total += c.getPrice();
            orderItems.setProductItemId(c.getProductId());
            orderItems.setPrice(c.getPrice());
            orderItems.setQuantity(c.getQuantity());
            o.getOrderItems().add(orderItems);
            this.orderItemsRepository.save(orderItems);
        }
        o.setOrderTotal(total);
        this.orderRepository.save(o);
        this.cartService.removeAllItems(ord.getCustomerId());
        this.warehouseservice.updateProduct(o);
        log.error(o);
        log.info("Deleted and placed");
        return new ResponseEntity("Order Placed", HttpStatus.OK);
    }

    public ResponseEntity returnOrder(String customerId, String orderId){
        Order o;
        try {
            o = this.orderRepository.findOrderById(customerId, orderId);
        }catch (Exception e){
            return new ResponseEntity("No order Found",HttpStatus.NOT_FOUND);
        }
        o.setOrderStatus(false);
        this.orderRepository.save(o);
        return new ResponseEntity("Order Request Placed", HttpStatus.OK);
    }
}
