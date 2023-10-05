package com.charlles.stock.repositories;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProductSpecification {
    public int updateProduct(Long productId, String name, Integer quantity, LocalDate expirationDate);
}
