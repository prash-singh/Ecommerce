package com.project.ecommerce.products.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ProductCatogery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private long categoryId;
    private String name;
    @OneToMany
    @JoinColumn(name = "categoryId")
    private List<Product> products;
}
