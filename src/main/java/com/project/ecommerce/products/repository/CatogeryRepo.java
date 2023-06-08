package com.project.ecommerce.products.repository;

import com.project.ecommerce.products.entities.ProductCatogery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatogeryRepo extends JpaRepository<ProductCatogery,Long> {
    @Query("Select p from ProductCatogery p where p.name =:n")
    public List<ProductCatogery> findByNames(@Param("n")  String name);

}
