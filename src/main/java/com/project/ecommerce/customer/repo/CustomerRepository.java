package com.project.ecommerce.customer.repo;

import com.project.ecommerce.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface CustomerRepository extends JpaRepository<CustomerEntity,String> {

}






