package com.project.ecommerce.orders.repository;

import com.project.ecommerce.orders.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems,String> {
}
