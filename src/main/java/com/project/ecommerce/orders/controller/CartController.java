package com.project.ecommerce.orders.controller;

import com.project.ecommerce.orders.dto.CartDTO;
import com.project.ecommerce.orders.entities.Cart;
import com.project.ecommerce.orders.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/cart")
    public List<Cart> getCart(){
        return this.cartService.getCart();
    }

    @PostMapping("/cart")
    public CartDTO addCart(@RequestBody CartDTO a){
        this.cartService.addCart(a);
        return a;
    }


}
