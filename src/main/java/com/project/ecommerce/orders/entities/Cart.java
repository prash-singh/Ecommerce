package com.project.ecommerce.orders.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cart_id")
    private String id;

//    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "fk_customer_id")
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cart_id")
    private List<CartItems> cartItems;
}
