package com.project.ecommerce.products.entities;

import jakarta.persistence.Id;

public class ProductCatogery {
    @Id
    private long category_id;
    private String name;

    private long productId ;
}
