package com.project.ecommerce.products.Repositiry;

import com.project.ecommerce.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product,Long> {


}
