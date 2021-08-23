package com.goIt.ProductManagement.model.service.converter;

import java.util.Set;
import java.util.stream.Collectors;

public interface Converter<DAO, DTO> {
    DTO toDTO(DAO dao);

    DAO fromDTO(DTO dto);

    default Set<DTO> toDTOSet(Set<DAO> dao) {
        return dao.stream().map(this::toDTO).collect(Collectors.toSet());
    }

    default Set<DAO> fromDTOSet(Set<DTO> dto) {
        return dto.stream().map(this::fromDTO).collect(Collectors.toSet());
    }
}
