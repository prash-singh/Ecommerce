package com.project.ecommerce.customer.repository;

import com.project.ecommerce.customer.entities.CustomerEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface CustomerRepository extends JpaRepository<CustomerEntities,String> {
    @Query("Select c from CustomerEntities c where c.emailId =:email")
    public CustomerEntities findByEmail(@Param("email") String email);

    @Query("Select c from CustomerEntities c where c.emailId =:email and c.password =:password")
    public CustomerEntities findByEmailAndPassword(@Param("email") String emailId, @Param("password") String password);

    @Query("Select c from CustomerEntities c where c.customerId =:customerId")
    public List<CustomerEntities> findAllByCustomerId(@Param("customerId") String customerId);

}









