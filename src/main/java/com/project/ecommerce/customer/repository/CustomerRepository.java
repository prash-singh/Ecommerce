package com.project.ecommerce.customer.repository;

import com.project.ecommerce.customer.entities.CustomerEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface CustomerRepository extends JpaRepository<CustomerEntities,String> {
}






