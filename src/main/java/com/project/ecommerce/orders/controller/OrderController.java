package com.project.ecommerce.orders.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.orders.dto.OrderDTO;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping(Constants.GET_ORDER_BY_CUSTOMER_ID)
    public List<Order> getUserOrder(@RequestHeader String customerId){
        return this.orderService.getOrder(customerId);
    }

    @PostMapping(Constants.PLACE_NEW_ORDER)
    public String placeNewOrder(@RequestBody OrderDTO ord){
        return this.orderService.placeOrder(ord);
    }

    @PutMapping(Constants.RETURN_ORDER)
    public String returnOrder(@RequestHeader String customerId, @RequestHeader String orderId){
        return this.orderService.returnOrder(customerId,orderId);
    }


}
