package com.project.ecommerce.orders.controller;

import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.services.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    private CartService cartService;
    @GetMapping("/cart")
    public List<Cart> getCart(){
        return this.cartService.getCart();
    }


}
