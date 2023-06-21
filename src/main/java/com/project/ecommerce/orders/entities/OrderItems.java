package com.project.ecommerce.orders.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_items")
public class OrderItems {
    @Id
    @Column(name = "order_items_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "product_items_id")
    private String productItemId;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "price")
    private double price;
}
