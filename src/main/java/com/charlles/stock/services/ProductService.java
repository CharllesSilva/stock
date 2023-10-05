package com.charlles.stock.services;

import com.charlles.stock.dto.ProductDTO;
import com.charlles.stock.entities.Product;
import com.charlles.stock.repositories.ProductRepository;
import com.charlles.stock.repositories.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSpecification productSpecification;

    public List<ProductDTO> findAll(){
        List<Product> result = productRepository.findAll();
        return result.stream().map(x -> new ProductDTO(x)).toList();
    }

    public ProductDTO saveProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        ProductDTO productDTO = new ProductDTO(savedProduct);
        return productDTO;

    }

    @Transactional
    public void updateProduct(Long productId, String newName, int newQuantity, LocalDate newExpirationDate) {
        productSpecification.updateProduct(productId, newName, newQuantity, newExpirationDate);
    }
}
