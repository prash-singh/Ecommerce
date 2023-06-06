package com.project.ecommerce.warehouse.repository;

import com.project.ecommerce.warehouse.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Shipmentdao extends JpaRepository<Shipment,String> {
}
