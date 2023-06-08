package com.project.ecommerce.products.services;
import com.project.ecommerce.products.entities.ProductCatogery;
import com.project.ecommerce.products.repository.CatogeryRepo;
import com.project.ecommerce.products.repository.ProductRepo;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.warehouse.repository.Warehousedao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.project.ecommerce.warehouse.entities.Warehouse;
import org.springframework.data.domain.Pageable;

import java.util.*;
@Service
public class ProductServicesImp implements ProductServices{


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CatogeryRepo catogeryRepo;

    @Autowired
    private Warehousedao warehousedao;



    @Override
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(String  id) {
        return productRepo.findById(id).get();
    }

    @Override
    public String addProduct(Product product, Long wareHouseID) {
        Warehouse warehouse=warehousedao.findById(wareHouseID).get();
        if(warehouse !=null) {
          List<Product> products=warehouse.getProducts();
          products.add(product);
          warehouse.setProducts(products);
          warehousedao.save(warehouse);
          productRepo.save(product);
          return "product added";
        }
        return "warehouse not exist";
    }

    public String updateProduct(String  id) {
        Product p= productRepo.findById(id).get();


        if(p != null){
             p.setSize("XXL");
             p.setName("Lui");
            productRepo.save(p);
            return  "UPDATED";
        }
        else{
            return "Check for given ID";
        }



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

    @Override
    public List<ProductCatogery> getCatogery() {
        return catogeryRepo.findAll();
    }

//    @Override
//    public List<Product> getProductByPage(int pageNo) {
//        int pageSize = 10;
//        Pageable pg = PageRequest.of(pageNo,pageSize);
//        return (List<Product>) productRepo.findAll(pg);
//
//
//    }


}

