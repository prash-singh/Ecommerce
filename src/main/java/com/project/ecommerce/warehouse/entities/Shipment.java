package com.project.ecommerce.warehouse.entities;

import com.project.ecommerce.orders.entities.Order;
import jakarta.persistence.*;
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

    private Long originwareHouseId;

    private Long destinationWarehouseId;
    @OneToMany
    @JoinColumn(name = "shipmentId")
    private List<Order> Orders;

}
