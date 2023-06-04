package com.project.ecommerce.orders.repository;

import com.project.ecommerce.orders.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
