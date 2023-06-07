package com.project.ecommerce.products.controller;

import com.project.ecommerce.products.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.ecommerce.products.entities.Product;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductServices productservices;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> list = this.productservices.getProducts();
        if(list.isEmpty() ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable String  id){
        return this.productservices.getProduct(id);
    }
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return  this.productservices.addProduct(product);
    }
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable String  id){
        return this.productservices.updateProduct(id);
    }
    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable String  id){
        return this.productservices.deleteProduct(id);
    }
    @GetMapping("/products/{name}")
    public Product getProductName(@PathVariable String name){
        return this.productservices.getProductName(name);
    }





}
