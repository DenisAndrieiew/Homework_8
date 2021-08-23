package com.goIt.ProductManagement.model.service;

import java.util.Set;
import java.util.UUID;

public interface EntityService<DTO> {
    DTO findById(UUID id);
    Set<DTO> findAll();
    void save(DTO dto);
    void delete(UUID id);
}
