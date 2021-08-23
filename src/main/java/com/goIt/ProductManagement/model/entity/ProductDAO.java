package com.goIt.ProductManagement.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductDAO {
    @Id
    @Column(name = "identifier")
    private UUID id;
    @Column(name="product_name")
    private String name;
    @Column(name = "product_cost")
    private BigDecimal cost;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    ManufacturerDAO manufacturer;

    public ProductDAO() {
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public ManufacturerDAO getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerDAO manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDAO)) return false;
        ProductDAO that = (ProductDAO) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
