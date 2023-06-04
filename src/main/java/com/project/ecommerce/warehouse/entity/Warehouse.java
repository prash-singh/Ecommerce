package com.project.ecommerce.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Warehouse {
    @Id
    private Long wareHouseId;

    private String name;

    private String location;

    private Long warehousecapacity;


    private Long availablestock;
}
