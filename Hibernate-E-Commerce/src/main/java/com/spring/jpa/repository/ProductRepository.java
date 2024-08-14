package com.spring.jpa.repository;

import com.spring.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    // Query finder method

    List<Product> findByName(String name);
    Product findFirstByName(String name);
    Product findLastByName(String name);


}
