package com.charlles.stock.dto;

import com.charlles.stock.entities.Product;

import java.time.LocalDate;
import java.util.List;

public class ProductDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;

    public ProductDTO(List<ProductDTO> result) {
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.quantity = entity.getQuantity();
        this.expirationDate = entity.getExpirationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
