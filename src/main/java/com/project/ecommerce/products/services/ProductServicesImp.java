package com.project.ecommerce.products.services;
import com.project.ecommerce.products.entities.ProductCatogery;
import com.project.ecommerce.products.repository.CatogeryRepo;
import com.project.ecommerce.products.repository.ProductRepo;
import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.project.ecommerce.warehouse.entities.Warehouse;
import org.springframework.data.domain.Pageable;

import java.util.*;
@Service
public class ProductServicesImp implements ProductServices {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CatogeryRepo catogeryRepo;

    @Autowired
    private WarehouseRepository warehouseRepository;


    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(String id) {
         Product pr= productRepo.findById(id).get();
        if(pr!=null) return pr;
        else throw new NoSuchElementException("product not available with id");

    }

    @Override
    public String addProduct(Product product, Long wareHouseID) {
        Warehouse warehouse = warehouseRepository.findById(wareHouseID).get();
        if (warehouse != null) {
            List<Product> products = warehouse.getProducts();
            products.add(product);
            warehouse.setProducts(products);
            warehouseRepository.save(warehouse);
            productRepo.save(product);
            return "product added";
        }
        return "warehouse not exist";
    }

    public String updateProduct(String id) {
        Product p = productRepo.findById(id).get();


        if (p != null) {
            p.setSize("XXL");
            p.setName("Lui");
            productRepo.save(p);
            return "UPDATED";
        } else {
            return "Check for given ID";
        }


    }

    @Override
    public Product deleteProduct(String id) {
        Product product = productRepo.findById(id).get();
        productRepo.deleteById(id);
        return product;
    }

    @Override
    public List<Product> getProductName(String name) {
        List<Product> products=productRepo.findByName(name);
        //Product product = productRepo.findByName(name);
        if(products.size()>0) {
            return products;
        }
        else throw new NoSuchElementException("product with this name not found");

    }

    @Override
    public List<ProductCatogery> getCatogeryType(String name) {
        List lis = this.catogeryRepo.findByNames(name);
        if(lis.isEmpty()){
            throw new NoSuchElementException("Catogery Type not Present");
        }

        return (List<ProductCatogery>) lis;
    }

    @Override
    public List<ProductCatogery> getCatogery() {
        return catogeryRepo.findAll();
    }

    @Override
    public List<Product> getProductByPage(int pageNo) {
        int pageSize = 10;
        Pageable pg = PageRequest.of(pageNo, pageSize);
        Page<Product> list = this.productRepo.findAll(pg);
        List<Product> content= list.getContent();
        return content;


//
//    }


    }
}
