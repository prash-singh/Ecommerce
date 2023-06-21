package com.project.ecommerce.warehouse.repository;

import com.project.ecommerce.warehouse.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Warehousedao extends JpaRepository<Warehouse,Long> {

    @Query("SELECT a from Warehouse a WHERE a.overallSellWarehouse =( SELECT MAX(a.overallSellWarehouse) from Warehouse a )")
    public Warehouse warehousewithmaximumprofit();


}
