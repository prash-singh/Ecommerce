package com.project.ecommerce.products.services;

import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.products.entities.ProductCatogery;

import java.util.List;

public interface ProductServices {

    public List<Product> getProducts();

    public Product getProduct(String id);
    public String addProduct(Product product, Long wareHouseID);
    public String updateProduct(String id);
    public Product deleteProduct(String id);
    public List<Product> getProductName(String name);

   public List<ProductCatogery> getCatogeryType(String name);

    public List<ProductCatogery> getCatogery();

    public List<Product> getProductByPage(int pageNo);


}
