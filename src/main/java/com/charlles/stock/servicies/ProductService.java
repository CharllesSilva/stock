package com.charlles.stock.servicies;

import com.charlles.stock.dto.ProductDTO;
import com.charlles.stock.entities.Product;
import com.charlles.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> result = productRepository.findAll();
        return result.stream().map(x -> new ProductDTO(x)).toList();
    }

    @PostMapping("/saveProduct")
    public ProductDTO saveProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        ProductDTO productDTO = new ProductDTO(savedProduct);
        return productDTO;

    }
}
