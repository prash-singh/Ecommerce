package com.project.ecommerce.orders.repository;

import com.project.ecommerce.orders.entities.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, String> {
}
