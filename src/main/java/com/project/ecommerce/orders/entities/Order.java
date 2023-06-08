package com.project.ecommerce.orders.entities;

import com.project.ecommerce.customer.entities.AddressEntities;
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
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_date")
    private String date;

    @Column(name = "order_total")
    private double orderTotal;

    @OneToOne
    @JoinColumn(name = "shipping_address")
    private AddressEntities shippingAddress;
//    private String shippingAddress;

    @Column(name = "order_status")
    private boolean orderStatus;



    @JoinColumn(name = "fk_shop_order_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

}
