package com.project.ecommerce.products.controller;


import com.project.ecommerce.Constants;
import com.project.ecommerce.products.services.ProductServices;
import com.project.ecommerce.warehouse.entities.Warehouse;
import com.project.ecommerce.warehouse.repository.Warehousedao;
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

    @Autowired
    private Warehousedao warehousedao;

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
    @GetMapping("/productPage/{pageNp}")

//    public List<Product> getProductByPage(@PathVariable int pageNo){
//        return this.productservices.getProductByPage(pageNo);
//
//    }
    @PostMapping(Constants.ADD_PRODUCT)
    public String addProduct(@RequestBody Product product, @PathVariable Long warehouseId){

         return  this.productservices.addProduct(product,warehouseId);
    }
    @PutMapping(Constants.UPDATE_PRODUCT)
    public String updateProduct(@PathVariable String  id){
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
