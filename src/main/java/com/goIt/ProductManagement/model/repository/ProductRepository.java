package com.goIt.ProductManagement.model.repository;

import com.goIt.ProductManagement.model.entity.ProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductDAO, UUID> {
    Optional<ProductDAO> findByName(String name);
}
