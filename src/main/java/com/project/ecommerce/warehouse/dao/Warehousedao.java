package com.project.ecommerce.warehouse.dao;

import com.project.ecommerce.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Warehousedao extends JpaRepository<Warehouse,Long> {
}
