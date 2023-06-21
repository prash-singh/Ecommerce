package com.project.ecommerce.customer.entities;

import jakarta.persistence.*;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
@Entity
@Data
@Table(name ="Customer_user")

public class CustomerEntities {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerId;

    @NotBlank
    @Column(name= "user_name")
    private String username;

    @NotBlank
    @Column(name="email_id")
    private String emailId;

    @NotNull
    @Column(name="phone_number")
    private long phoneNumber;

    @NotNull
    @Column(name="password")
    private String password;

    @JoinColumn(name= "fk_customer_address_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<AddressEntities> address;
}

