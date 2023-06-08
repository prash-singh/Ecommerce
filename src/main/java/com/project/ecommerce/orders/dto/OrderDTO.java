package com.project.ecommerce.orders.dto;

import com.project.ecommerce.customer.entities.AddressEntities;
import lombok.Data;

@Data
public class OrderDTO {
    private String customerId;
    private AddressEntities shippingAddress;
//    private String shippingAddress;
}
