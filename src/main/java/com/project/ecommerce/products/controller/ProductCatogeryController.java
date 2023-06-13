package com.project.ecommerce.products.controller;

import com.project.ecommerce.Constants;
import com.project.ecommerce.products.entities.ProductCatogery;
import com.project.ecommerce.products.repository.CatogeryRepo;
import com.project.ecommerce.products.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductCatogeryController {

    @Autowired
    private  CatogeryRepo productCatogery;
    @Autowired
    private ProductServices productServices;
    @GetMapping(Constants.GET_ALL_CATOGERYES)
    public List<ProductCatogery> getCatogery(){
        return productCatogery.findAll();
    }
    @GetMapping(Constants.GET_CATOGERY_NAME)
    public List<ProductCatogery> getCatogeryType(@PathVariable String name){
        return this.productServices.getCatogeryType(name);
    }
}
