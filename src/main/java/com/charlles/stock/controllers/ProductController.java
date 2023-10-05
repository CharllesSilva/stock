package com.charlles.stock.controllers;

import com.charlles.stock.dto.ProductDTO;
import com.charlles.stock.entities.Product;
import com.charlles.stock.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> result = productService.findAll();
        return ResponseEntity.ok().body(result);

    }

    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product) {
        ProductDTO savedProduct = productService.saveProduct(product);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedProduct);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId,
            @RequestParam String newName,
            @RequestParam int newQuantity,
            @RequestParam LocalDate newExpirationDate

    ) {
        productService.updateProduct(productId, newName, newQuantity, newExpirationDate);
        return ResponseEntity.ok().build();
    }
}
