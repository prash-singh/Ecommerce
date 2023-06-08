package com.project.ecommerce.products.services;

import com.project.ecommerce.products.entities.Product;
import com.project.ecommerce.products.entities.ProductCatogery;

import java.util.List;

public interface ProductServices {

    public List<Product> getProducts();

    public Product getProduct(String id);
    public Product addProduct(Product product);
    public Product updateProduct(String id);
    public Product deleteProduct(String id);
    public Product getProductName(String name);

   public List<ProductCatogery> getCatogeryType(String name);


}
