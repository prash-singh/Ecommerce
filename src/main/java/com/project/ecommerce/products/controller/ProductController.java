package com.project.ecommerce.products.controller;

import com.project.ecommerce.products.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.project.ecommerce.products.entities.Product;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductServices productservices;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.productservices.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable long id){
        return this.productservices.getProduct(id);
    }
    @PostMapping("/product/")
    public Product addProduct(@RequestBody Product product){
        return  this.productservices.addProduct(product);
    }
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable long id){
        return this.productservices.updateProduct(id);
    }
    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable long id){
        return this.productservices.deleteProduct(id);
    }




}
