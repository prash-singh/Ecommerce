package com.project.ecommerce.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name ="Customer_user")

public class CustomerEntity {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerId;

    @Column(name= "user_name")
    private String username;

    @Column(name="email_id")
    private String emailId;

    @Column(name="phone_number")
    private Long phoneNumber;

    @Column(name="password")
    private String password;

    @JoinColumn(name= "fk_customer_address_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<AddressEntity> address;
}

