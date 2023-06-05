package com.project.ecommerce.products.controller;

import com.project.ecommerce.products.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.ecommerce.products.entities.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductServices productservices;
    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.productservices.getProducts();
    }




}
