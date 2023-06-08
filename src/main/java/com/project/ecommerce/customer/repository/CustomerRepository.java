package com.project.ecommerce.customer.repository;

import com.project.ecommerce.customer.entities.CustomerEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public  interface CustomerRepository extends JpaRepository<CustomerEntities,String>
{
    @Query("Select c from CustomerEntities c where c.emailId =:email")
    public CustomerEntities findByEmail(@Param("email") String email);
    @Query("Select c from CustomerEntities c where c.emailId =:email and c.password =:password")
    public CustomerEntities findByEmailAndPassword(@Param("email")String emailId,@Param("password")String password);
}






