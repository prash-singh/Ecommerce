package com.project.ecommerce.products.services;
import com.project.ecommerce.products.entities.ProductCatogery;
import com.project.ecommerce.products.repository.CatogeryRepo;
import com.project.ecommerce.products.repository.ProductRepo;
import com.project.ecommerce.products.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProductServicesImp implements ProductServices{


    @Autowired
    private ProductRepo productRepo;

    @Autowired CatogeryRepo catogeryRepo;
    @Override
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(String  id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(String  id) {
        Product product= productRepo.findById(id).get();
        product.setName("yutr");
        productRepo.save(product);
        return  product;
    }

    @Override
    public Product deleteProduct(String  id) {
        Product product = productRepo.findById(id).get();
        productRepo.deleteById(id);
        return product;
    }

    @Override
    public Product getProductName(String name) {
        return  productRepo.findByName(name);
    }

   @Override
   public List<ProductCatogery> getCatogeryType(String name) {
        return (List<ProductCatogery>) this.catogeryRepo.findByNames(name);
    }


}

