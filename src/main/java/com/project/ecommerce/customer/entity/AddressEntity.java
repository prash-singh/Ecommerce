package com.project.ecommerce.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="address")

public class AddressEntity {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String addressId;

    @Column(name="address_Line1")
    private String addressLine1;

    private String city;

    private String region;

    private String state;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="Country")
    private String country;
}
