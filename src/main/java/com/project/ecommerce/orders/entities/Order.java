package com.project.ecommerce.orders.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "shop_order")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userid;

    @Column(name = "order_date")
    private String date;

    @Column(name = "order_total")
    private double orderTotal;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "order_status")
    private boolean orderStatus;



    @JoinColumn(name = "fk_shop_order_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;
}
