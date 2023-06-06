package com.project.ecommerce.orders.dto;

import lombok.Data;

@Data
public class CartDTO {
    String userId;
    String productId;
    long quantity;
}
