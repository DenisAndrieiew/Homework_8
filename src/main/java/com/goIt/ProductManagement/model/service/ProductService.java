package com.goIt.ProductManagement.model.service;

import com.goIt.ProductManagement.model.dto.ProductDTO;
import com.goIt.ProductManagement.model.entity.ProductDAO;
import com.goIt.ProductManagement.model.repository.ProductRepository;
import com.goIt.ProductManagement.model.service.converter.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Service
public class ProductService implements EntityService<ProductDTO> {
    private ProductRepository repository;
    private ProductConverter converter;

    @Autowired

    public ProductService(ProductRepository repository, ProductConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ProductDTO findById(UUID id) {
        return converter.toDTO(repository.getById(id));
    }

    @Override
    public Set<ProductDTO> findAll() {
        return converter.toDTOSet(new HashSet<>(repository.findAll()));
    }

    @Override
    public void save(ProductDTO productDTO) {
        ProductDAO productDAO = converter.fromDTO(productDTO);
        if (Objects.isNull(productDAO.getId())) {
            productDAO.setId(UUID.randomUUID());
        }
        repository.save(productDAO);
    }


    @Override
    public void delete(UUID id) {
        repository.delete(repository.getById(id));
    }
}
