package com.project.ecommerce.products.controller;


import com.project.ecommerce.Constants;
import com.project.ecommerce.products.services.ProductServices;
import org.apache.tomcat.util.bcel.classfile.Constant;
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

    @GetMapping(Constants.GET_ALL_PRODUCT)
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> list = this.productservices.getProducts();
        if(list.isEmpty() ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping(Constants.GET_ONE_PRODUCT)
    public Product getProduct(@PathVariable String  id){
        return this.productservices.getProduct(id);
    }
    @PostMapping(Constants.ADD_PRODUCT)
    public Product addProduct(@RequestBody Product product){
        return  this.productservices.addProduct(product);
    }
    @PutMapping(Constants.UPDATE_PRODUCT)
    public Product updateProduct(@PathVariable String  id){
        return this.productservices.updateProduct(id);
    }
    @DeleteMapping(Constants.DELETE_PRODUCT)
    public Product deleteProduct(@PathVariable String  id){
        return this.productservices.deleteProduct(id);
    }
    @GetMapping(Constants.GET_PRODUCT_NAME)
    public Product getProductName(@PathVariable String name){
        return this.productservices.getProductName(name);
    }





}
