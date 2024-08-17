package com.spring.jpa.controller;

import com.spring.jpa.entity.ProductCategory;
import com.spring.jpa.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productCategory")
@AllArgsConstructor
public class ProductCategoryController {
    private ProductCategoryRepository repository;
    @PostMapping
    public ResponseEntity<ProductCategory> addProductCategory(@RequestBody ProductCategory productCategory ){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(productCategory));
    }

    @PostMapping("/addAll/productCategory")
    public ResponseEntity<List<ProductCategory>> addAllProductCategory(@RequestBody List<ProductCategory> categories){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.saveAll(categories));
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategory(){
        return ResponseEntity.ok(repository.findAll());
    }

}
