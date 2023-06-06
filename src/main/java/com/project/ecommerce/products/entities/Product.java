package com.project.ecommerce.products.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String  name;
    private String description ;
    @Column(name = "product_price")
    private long productPrice;
    private String size;
    private String colour;
    private String brand;
    private long availQuantity;
    private long warehouseStock;



}
