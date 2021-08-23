package com.goIt.ProductManagement.model.service.converter;

import com.goIt.ProductManagement.model.dto.ManufacturerDTO;
import com.goIt.ProductManagement.model.entity.ManufacturerDAO;
import com.goIt.ProductManagement.model.entity.ProductDAO;
import com.goIt.ProductManagement.model.exceptions.ObjectNotFoundException;
import com.goIt.ProductManagement.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class ManufacturerConverter implements Converter<ManufacturerDAO, ManufacturerDTO> {
    private ProductRepository repository;

    @Autowired
    public ManufacturerConverter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ManufacturerDTO toDTO(ManufacturerDAO manufacturerDAO) {
        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
        manufacturerDTO.setId(manufacturerDAO.getId());
        manufacturerDTO.setName(manufacturerDAO.getName());
        manufacturerDTO.setProductNames(manufacturerDAO.getProducts().stream().map(ProductDAO::getName)
                .collect(Collectors.toSet()));
        return manufacturerDTO;
    }

    @Override
    public ManufacturerDAO fromDTO(ManufacturerDTO manufacturerDTO) {
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        manufacturerDAO.setName(manufacturerDTO.getName());
        manufacturerDAO.setId(manufacturerDTO.getId());
        manufacturerDAO.setProducts(manufacturerDTO.getProductNames().stream().map(productName ->
                repository.findByName(productName).orElseThrow(() ->
                        new ObjectNotFoundException(String.format
                                ("product %s not exist", productName))))
                .collect(Collectors.toSet()));
        return manufacturerDAO;
    }
}
