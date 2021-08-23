package com.goIt.ProductManagement.model.repository;

import com.goIt.ProductManagement.model.entity.ManufacturerDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<ManufacturerDAO, UUID> {
    Optional<ManufacturerDAO> findByName(String name);
}
