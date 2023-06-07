package com.project.ecommerce.customer.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name="address")

public class AddressEntities {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String addressId;

    @Column(name="address_Line")
    private String addressLine;

    @Column(name="City")
    private String city;

    @Column(name="Region")
    private String region;

    @Column(name="State")
    private String state;

    @Column(name="Postal_Code")
    private String postalCode;

    @Column(name="Country")
    private String country;
}
