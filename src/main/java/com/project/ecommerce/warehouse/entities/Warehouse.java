package com.project.ecommerce.warehouse.entities;

import com.project.ecommerce.products.entities.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.EmbeddableInstantiator;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Warehouse {
    @Id
    @NotNull(message = "Please provide warehouseid")
    private Long wareHouseId;

    @NotBlank(message = "name must not be empty")
    private String name;

    @NotBlank(message = "Location must not be empty")
    private String location;
    @Max(10000)
    @NotNull(message = "warehousecapacity mustnot be null")
    private Long warehouseCapacity;
    @NotNull(message="available stock must be zero initially")

    private Long availableStock;
    @NotNull(message="overall sell  must be zero initially")

    private double overallSellWarehouse;

    @NotNull(message="total quantity sell   must be zero initially")

    private Long totalQuantitySell;


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "warehouse_id")
    private List<Product> products;
}
