package com.project.ecommerce.products.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String  name;
    private String description ;
    private String product_image;
    private long product_price;
    private String size;
    private String colour;

    private String brand;
    private long availQuantity;
    private long warehouseStock;

}
