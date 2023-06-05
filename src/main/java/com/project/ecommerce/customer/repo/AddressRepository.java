package com.project.ecommerce.customer.repo;

import com.project.ecommerce.customer.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,String> {
}
