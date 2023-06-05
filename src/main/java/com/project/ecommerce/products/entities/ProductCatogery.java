package com.project.ecommerce.products.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ProductCatogery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long category_id;
    private String name;
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products;
}
