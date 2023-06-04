package com.project.ecommerce.orders.controller;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shop_order")
public class OrderController {
    @Id
    @Column(name = "order_id")
    private String id;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private String timestamp;
}
