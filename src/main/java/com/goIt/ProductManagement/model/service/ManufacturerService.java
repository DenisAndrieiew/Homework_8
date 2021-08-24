package com.goIt.ProductManagement.model.service;

import com.goIt.ProductManagement.model.dto.ManufacturerDTO;
import com.goIt.ProductManagement.model.entity.ManufacturerDAO;
import com.goIt.ProductManagement.model.repository.ManufacturerRepository;
import com.goIt.ProductManagement.model.service.converter.ManufacturerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManufacturerService implements EntityService<ManufacturerDTO> {
    private ManufacturerRepository repository;
    private ManufacturerConverter converter;

    @Autowired
    public ManufacturerService(ManufacturerRepository repository, ManufacturerConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ManufacturerDTO findById(UUID id) {
        return converter.toDTO(repository.getById(id));
    }

    @Override
    public Set<ManufacturerDTO> findAll() {
        return converter.toDTOSet(new HashSet<>(repository.findAll()));
    }

    @Override
    public void save(ManufacturerDTO manufacturerDTO) {

        ManufacturerDAO manufacturerDAO = converter.fromDTO(manufacturerDTO);
        if (Objects.isNull(manufacturerDAO.getId())) {
            manufacturerDAO.setId(UUID.randomUUID());
        }
        repository.save(manufacturerDAO);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(repository.getById(id));
    }

    public Set<String> getNames(){
        return repository.findAll().stream().map(ManufacturerDAO::getName).collect(Collectors.toSet());
    }
}
