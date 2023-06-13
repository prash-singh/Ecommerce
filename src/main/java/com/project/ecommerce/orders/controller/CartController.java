package com.project.ecommerce.orders.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.customer.entities.CustomerEntities;
import com.project.ecommerce.customer.repository.CustomerRepository;
import com.project.ecommerce.customer.service.CustomerImplements;
import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.services.CartItemsService;
import com.project.ecommerce.orders.services.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@Log4j2
@Validated
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemsService cartItemsService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(Constants.GET_CART_BY_USERID)
    public ResponseEntity<Object> getCartByUserId(@RequestHeader String customerId){
        Cart cart = this.cartService.getByUserId(customerId);
        try{this.customerRepository.findById(customerId).get();}catch(Exception e){
            log.info("Customer not found");
            return new ResponseEntity<>("Invalid CustomerId", HttpStatus.NOT_ACCEPTABLE);
        }

        if(cart==null || cart.getCartItems().isEmpty()){
            return new ResponseEntity<>("Cart is Empty",HttpStatus.OK);
        }
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }


    @PostMapping(Constants.ADD_ITEMS_TO_CART)
    public ResponseEntity<String> addCart(@RequestBody CartDTO cart){
        return this.cartService.addCart(cart);
    }

    @PutMapping(Constants.UPDATE_CART_QUANTITY)
    public ResponseEntity<String> updateQty(@RequestHeader String customerId, @RequestHeader String productId,@RequestHeader boolean operationType){
        return this.cartItemsService.updateQty(customerId,productId,operationType);
    }

    @DeleteMapping(Constants.DELETE_CART_ITEM_BY_ID)
    public ResponseEntity<Object> remove(@RequestHeader String customerId,@PathVariable String cartItemId){
        return this.cartItemsService.deleteById(customerId,cartItemId);
    }

    @DeleteMapping(Constants.DELETE_ALL_CART_ITEMS)
    public void removeAll(@RequestHeader String customerId){
         this.cartService.removeAllItems(customerId);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<String> handleTypeMismatch() {
        return new ResponseEntity<>("Check if all provided value is correct",HttpStatus.NOT_ACCEPTABLE);
    }
}
