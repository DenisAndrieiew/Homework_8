package com.goIt.ProductManagement.model.service.converter;

import com.goIt.ProductManagement.model.dto.ProductDTO;
import com.goIt.ProductManagement.model.entity.ProductDAO;
import com.goIt.ProductManagement.model.exceptions.ObjectNotFoundException;
import com.goIt.ProductManagement.model.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class ProductConverter implements Converter<ProductDAO, ProductDTO> {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ProductConverter(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public ProductDTO toDTO(ProductDAO productDAO) {
        ProductDTO dto = new ProductDTO();
        dto.setId(productDAO.getId());
        dto.setName(productDAO.getName());
        dto.setCost(productDAO.getCost());
        dto.setManufacturerName(productDAO.getManufacturer().getName());
        return dto;
    }

    @Override
    public ProductDAO fromDTO(ProductDTO productDTO) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setCost(productDTO.getCost());
        productDAO.setName(productDTO.getName());
        productDAO.setManufacturer(manufacturerRepository.findByName(productDTO.getManufacturerName()).orElseThrow
                        (()-> new ObjectNotFoundException(String.format
                                ("manufacturer %s not exist", productDTO.getManufacturerName()))));
        if (Objects.nonNull(productDTO.getId())){
            productDAO.setId(productDTO.getId());
        }
        return productDAO;
    }
}
