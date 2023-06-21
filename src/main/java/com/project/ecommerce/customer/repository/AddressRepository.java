package com.project.ecommerce.customer.repository;

import com.project.ecommerce.customer.entities.AddressEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntities,String> {


}
