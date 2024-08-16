package com.spring.jpa.controller;

import com.spring.jpa.entity.Product;
import com.spring.jpa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.addProduct(product));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Product>> addAllProduct(
            @RequestBody List<Product> products)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.addAllProduct(products));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable Long id){
        return ResponseEntity.ok(productService.existById(id));
    }

    @GetMapping("/findAllByIds")
    public ResponseEntity<List<Product>> findAllProductById(@RequestBody List<Long> id){
        return ResponseEntity.ok(productService.findAllProductById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAllProduct(){
        return ResponseEntity.ok(productService.findAllProduct());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> productCount(){
        return ResponseEntity.ok(productService.productCount());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteById(id));
    }

    @DeleteMapping("/deleteByProduct")
    public ResponseEntity<String> deleteByProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.deleteByProduct(product));
    }

    @DeleteMapping("/deleteAllById")
    public ResponseEntity<String> deleteAllById(@RequestBody List<Long> id){
        return ResponseEntity.ok(productService.deleteAllById(id));
    }

    @DeleteMapping("/deleteAllByProduct")
    public ResponseEntity<String> deleteAllByProduct(
            @RequestBody List<Product> products)
    {
        return ResponseEntity.ok(productService.deleteAllByProduct(products));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(){
        return ResponseEntity.ok(productService.deleteAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(
            @RequestBody Product product, @PathVariable Long id)
    {
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }

    // Query finder method
    @GetMapping("/get/{name}")
    public ResponseEntity<List<Product>> getAllProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.findByName(name));
    }

    @GetMapping("/get/first/{name}")
    public ResponseEntity<Product> getFirstProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.findFirstByName(name));
    }

    @GetMapping("/get/last/{name}")
    public ResponseEntity<Product> getLastProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.findLastByName(name));
    }

    // @Query
    @GetMapping("/get/{name}/{description}")
    public ResponseEntity<Product> findByNameOrDescription(@PathVariable String name, @PathVariable String description){
        return ResponseEntity.ok(productService.findByNameOrDesc(name, description));
    }

}
