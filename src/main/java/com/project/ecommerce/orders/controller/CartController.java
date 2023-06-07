package com.project.ecommerce.orders.controller;

import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.services.CartItemsService;
import com.project.ecommerce.orders.services.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemsService cartItemsService;
    @GetMapping("/cart")
    public List<Cart> getCart(){
        return this.cartService.getCart();
    }

    @GetMapping("/cart/{id}")
    public Cart getCartByUserId(@PathVariable String id){
        return this.cartService.getByUserId(id);
    }

    @PostMapping("/cart")
    public CartDTO addCart(@RequestBody CartDTO a){
        this.cartService.addCart(a);
        return a;
    }

    @PutMapping("/cart")
    public CartDTO updateQty(@RequestBody CartDTO a, @RequestHeader boolean operationType){
        this.cartItemsService.updateQty(a);
        log.info(operationType);
        return a;
    }

    @DeleteMapping("/cart/{userId}/delete/{id}")
    public String remove(@PathVariable String userId,@PathVariable String id){
        this.cartItemsService.deleteById(userId,id);
        return "Deleted";
    }


}
