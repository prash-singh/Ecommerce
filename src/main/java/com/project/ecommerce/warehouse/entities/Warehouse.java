package com.project.ecommerce.warehouse.entities;

import com.project.ecommerce.products.entities.Product;
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
public class Warehouse {
    @Id
    private Long wareHouseId;

    private String name;

    private String location;

    private Long warehousecapacity;


    private Long availablestock;

    private double Overall_sell_warehouse;


    @ManyToMany(cascade = { CascadeType.ALL })
   @JoinColumn(name = "warehouse_id")
    private List<Product> products;
}
