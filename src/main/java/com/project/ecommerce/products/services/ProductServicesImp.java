package com.project.ecommerce.products.services;
import com.project.ecommerce.products.Repositiry.ProductRepo;
import com.project.ecommerce.products.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProductServicesImp implements ProductServices{



    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getProducts(){
        return productRepo.findAll();
    }



    @Override
    public Product getProduct(String  id) {
        return productRepo.findById(Long.valueOf(id)).get();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(String  id) {
        Product product= productRepo.findById(Long.valueOf(id)).get();
        product.setName("yutr");
        productRepo.save(product);
        return  product;
    }

    @Override
    public Product deleteProduct(String  id) {
        Product product = productRepo.findById(Long.valueOf(id)).get();
        productRepo.deleteById(Long.valueOf(id));
        return product;
    }


}

