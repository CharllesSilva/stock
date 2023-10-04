package com.charlles.stock.controllers;

import com.charlles.stock.dto.ProductDTO;
import com.charlles.stock.entities.Product;
import com.charlles.stock.servicies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveProduct")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        ProductDTO savedProduct = productService.saveProduct(product);
        return new ResponseEntity(savedProduct, HttpStatus.CREATED);

    }

}
