package com.charlles.stock.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class ProductSpecifications implements ProductSpecificationRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public int updateProduct(Long productId, String name, Integer quantity, LocalDate expirationDate) {
        StringBuilder sql = new StringBuilder("UPDATE Product p SET");
        boolean hasSetClause = false;

        if (name != null && !name.isEmpty()) {
            sql.append(" p.name = :name");
            hasSetClause = true;
        }

        if (quantity != null) {
            if (hasSetClause) {
                sql.append(",");
            }
            sql.append(" p.quantity = :quantity");
            hasSetClause = true;
        }

        if (expirationDate != null) {
            if (hasSetClause) {
                sql.append(",");
            }
            sql.append(" p.expirationDate = :expirationDate");
        }

        sql.append(" WHERE p.id = :productId");

        Query query = entityManager.createQuery(sql.toString()).setParameter("productId", productId);

        if (name != null && !name.isEmpty()) {
            query.setParameter("name", name);
        }

        if (quantity != null) {
            query.setParameter("quantity", quantity);
        }

        if (expirationDate != null) {
            query.setParameter("expirationDate", expirationDate);
        }

        return query.executeUpdate();
    }
}


