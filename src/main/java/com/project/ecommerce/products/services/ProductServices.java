package com.project.ecommerce.products.services;

import com.project.ecommerce.products.entities.Product;

import java.util.List;

public interface ProductServices {

    public List<Product> getProducts();

    public Product getProduct(String id);

    public Product addProduct(Product product);
    public Product updateProduct(String id);
    public Product deleteProduct(String id);


}
