package com.spring.jpa.repository;

import com.spring.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    // Query finder method

    List<Product> findByName(String name);
    Product findFirstByName(String name);
    Product findLastByName(String name);

    // define JPQL query using @Query annotation with index or position parameters
    // @Query("select p from Product p where p.name= ?1 or p.description = ?2")
    // Named parameter
    //@Query("select p from Product p where p.name= :name or p.description = :description ")

    // native sql query using index parameter
    @Query(value = "select * from Products p where p.product_name= ?1 or p.description = ?2 ", nativeQuery = true)
    Product findByProductOrDescription(String name,  String description);

    Product findByPrice(BigDecimal price);

    @Query(nativeQuery = true)
    Product findByDescription(@Param("description") String description);
}
