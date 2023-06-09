package com.project.ecommerce.orders.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.services.CartItemsService;
import com.project.ecommerce.orders.services.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemsService cartItemsService;

    @GetMapping(Constants.GET_CART_BY_USERID)
    public Cart getCartByUserId(@PathVariable String id){
        Cart c = this.cartService.getByUserId(id);
        if(c.getCartItems().isEmpty()){
            throw new RuntimeException();
        }
        return c;
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> exception(){
        return new ResponseEntity<>("Cart is Empty",HttpStatus.OK);
    }

    @PostMapping(Constants.ADD_ITEMS_TO_CART)
    public ResponseEntity<String> addCart(@RequestBody CartDTO a){
        return this.cartService.addCart(a);
    }

    @PutMapping(Constants.UPDATE_CART_QUANTITY)
    public String updateQty(@RequestHeader String customerId, @RequestHeader String productId, @RequestHeader boolean operationType){
        this.cartItemsService.updateQty(customerId,productId,operationType);
        log.info(operationType);
        return "Updated";
    }

    @DeleteMapping(Constants.DELETE_CART_ITEM_BY_ID)
    public String remove(@RequestHeader String customerId,@PathVariable String id){
        this.cartItemsService.deleteById(customerId,id);
        return "Deleted";
    }

    @DeleteMapping(Constants.DELETE_ALL_CART_ITEMS)
    public void removeAll(@PathVariable("id") String customerId){
         this.cartService.removeAllItems(customerId);
    }
}
