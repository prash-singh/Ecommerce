package com.project.ecommerce.orders.repository;

import com.project.ecommerce.orders.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,String> {
    @Query("Select c from Cart c where c.customerId = :userId")
    public Cart getUserCart(@Param("userId") String id);
}
