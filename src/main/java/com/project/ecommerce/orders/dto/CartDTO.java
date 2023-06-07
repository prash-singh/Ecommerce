package com.project.ecommerce.orders.dto;

import lombok.Data;

@Data
public class CartDTO {
    String customerId;
    String productId;
    long quantity;
}
