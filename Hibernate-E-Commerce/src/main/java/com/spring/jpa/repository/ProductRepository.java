package com.spring.jpa.repository;

import com.spring.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    // Query finder method

    List<Product> findByName(String name);
    Product findFirstByName(String name);
    Product findLastByName(String name);

    // define JPQL query using @Query annotation with index or position parameters
    @Query("select p from Product p where p.name= ?1 or p.description = ?2")
    Product findByProductOrDescription(String name, String description);

}
