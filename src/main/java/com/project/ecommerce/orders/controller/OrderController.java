package com.project.ecommerce.orders.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.orders.dto.OrderDTO;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Valid
    @GetMapping(Constants.GET_ORDER_BY_CUSTOMER_ID)
    public ResponseEntity<Object> getUserOrder(@RequestHeader String customerId){
        List<Order> o= this.orderService.getOrder(customerId);
        if(o.isEmpty()){
            return new ResponseEntity<>("No previous Order Found",HttpStatus.OK);
        }
        return new ResponseEntity<>(o,HttpStatus.OK);
    }
    @Valid
    @PostMapping(Constants.PLACE_NEW_ORDER)
    public ResponseEntity<Object> placeNewOrder(@RequestBody OrderDTO ord){
        return this.orderService.placeOrder(ord);
    }
    @Valid
    @PutMapping(Constants.RETURN_ORDER)
    public ResponseEntity<Object> returnOrder(@RequestHeader String customerId, @RequestHeader String orderId){
        return this.orderService.returnOrder(customerId,orderId);
    }


}
