package com.project.ecommerce.orders.repository;

import com.project.ecommerce.orders.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    @Query("select o from Order o where o.customerId = :cId")
    public List<Order> findOrderByCustomerId(@Param("cId") String customerId);

    @Query("select o from Order o where o.customerId = :cId and o.id = :oId")
    public Order findOrderById(@Param("cId") String customerId, @Param("oId") String orderId);
}
