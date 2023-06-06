package com.project.ecommerce.warehouse.repository;

import com.project.ecommerce.warehouse.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Warehousedao extends JpaRepository<Warehouse,Long> {


}
