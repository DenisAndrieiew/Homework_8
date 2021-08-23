package com.goIt.ProductManagement.model.dto;

import java.util.Set;
import java.util.UUID;

public class ManufacturerDTO {
    private UUID id;
    private String name;
    private Set<String> productNames;

    public ManufacturerDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(Set<String> productNames) {
        this.productNames = productNames;
    }
}
