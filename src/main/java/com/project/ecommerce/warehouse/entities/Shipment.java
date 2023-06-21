package com.project.ecommerce.warehouse.entities;

import com.project.ecommerce.orders.entities.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String shipmentId;

    @NotNull(message = "origin warehouse must not be empty")
    private Long originwareHouseId;

    @NotNull(message = "destination warehouse id mustnot be null")
    private Long destinationWarehouseId;

    @OneToMany
    @JoinColumn(name = "shipmentId")
    private List<Order> Orders;

}
