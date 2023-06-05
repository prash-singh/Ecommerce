package com.project.ecommerce.orders.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cart_items")
public class CartItems {
    @Id
    @Column(name = "cart_items_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "price")
    private double price;
}
