package com.project.ecommerce.orders.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.orders.dto.OrderDTO;
import com.project.ecommerce.orders.entities.Order;
import com.project.ecommerce.orders.services.OrderService;
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


    @GetMapping(Constants.GET_ORDER_BY_CUSTOMER_ID)
    public List<Order> getUserOrder(@RequestHeader String customerId){
        List<Order> o= this.orderService.getOrder(customerId);
        if(o.isEmpty()){
            throw new RuntimeException();
        }
        return o;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> ex(){
        return new ResponseEntity<>("No previous Order Found", HttpStatus.OK);
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
