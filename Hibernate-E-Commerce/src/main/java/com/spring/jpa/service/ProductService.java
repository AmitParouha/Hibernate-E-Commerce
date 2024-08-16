package com.spring.jpa.service;

import com.spring.jpa.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);
    public List<Product> addAllProduct(List<Product> products);
    public Product findById(Long id);
    public boolean existById(Long id);
    public List<Product> findAllProductById(List<Long> id);
    public List<Product> findAllProduct();
    public Long productCount();
    public String deleteById(Long id);
    public String deleteByProduct(Product product);
    public String deleteAllById(List<Long> id);
    public String deleteAllByProduct(List<Product> products);
    public String deleteAll();
    public Product updateProduct(Product product, Long id);

    // query finder method
    List<Product> findByName(String name);
    Product findFirstByName(String name);
    Product findLastByName(String name);

    // @Query
    public Product findByNameOrDesc(String name, String description);

    //named Query
    public Product findByPrice(BigDecimal price);
}
