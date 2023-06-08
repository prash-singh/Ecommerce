package com.project.ecommerce.orders.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.services.CartItemsService;
import com.project.ecommerce.orders.services.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemsService cartItemsService;

    @GetMapping(Constants.GET_CART_BY_USERID)
    public Cart getCartByUserId(@PathVariable String id){
        return this.cartService.getByUserId(id);
    }

    @PostMapping(Constants.ADD_ITEMS_TO_CART)
    public CartDTO addCart(@RequestBody CartDTO a){
        this.cartService.addCart(a);
        return a;
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
