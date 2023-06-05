package com.project.ecommerce.products.services;
import com.project.ecommerce.products.Repositiry.ProductRepo;
import com.project.ecommerce.products.entities.Product;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProductServicesImp implements ProductServices{

    @Autowired
    private ProductRepo productRepo;
    public List<Product> getProducts(){
        return productRepo.findAll();
    }


}
