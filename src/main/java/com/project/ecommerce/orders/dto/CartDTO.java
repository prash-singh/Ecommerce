package com.project.ecommerce.orders.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CartDTO {
    String customerId;
    String productId;
    @Min(0)
    long quantity;
}
