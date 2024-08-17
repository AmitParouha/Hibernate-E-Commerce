package com.spring.jpa.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;
    private String categoryDescription;

    // Parent Table
    @OneToMany(cascade =CascadeType.ALL, mappedBy = "category",  orphanRemoval = true)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();
}
