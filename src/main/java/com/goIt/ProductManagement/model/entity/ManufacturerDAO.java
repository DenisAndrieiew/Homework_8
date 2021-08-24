package com.goIt.ProductManagement.model.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturers")
public class ManufacturerDAO {
    @Id
    @Column(name = "identifier")
    private UUID id;
    @Column(name="manufacturer_name")
    private String name;
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<ProductDAO> products;

    public ManufacturerDAO() {
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

    public Set<ProductDAO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDAO> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManufacturerDAO)) return false;
        ManufacturerDAO that = (ManufacturerDAO) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
