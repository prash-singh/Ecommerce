package com.project.ecommerce.customer.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="address")

public class AddressEntities {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String addressId;

    @NotBlank
    @Column(name="address_Line")

    private String addressLine;

    @NotBlank
    @Column(name="City")
    private String city;

    @NotBlank
    @Column(name="Region")
    private String region;

    @NotBlank
    @Column(name="State")
    private String state;

    @NotBlank
    @Column(name="Postal_Code")
    private String postalCode;

    @NotBlank
    @Column(name="Country")
    private String country;

     
}
