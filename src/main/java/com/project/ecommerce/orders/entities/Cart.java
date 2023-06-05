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

    @Column(name = "user_id")
    private String userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cart_id")
    private List<CartItems> cartItems;
}
