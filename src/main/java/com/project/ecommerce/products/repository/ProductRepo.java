package com.project.ecommerce.products.repository;

import com.project.ecommerce.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product,String> {
    @Query("Select p from Product p where p.name =:n")
    public Product findByName(@Param("n")  String name);



}
