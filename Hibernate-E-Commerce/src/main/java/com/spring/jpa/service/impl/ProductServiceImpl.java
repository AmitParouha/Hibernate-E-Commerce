package com.spring.jpa.service.impl;

import com.spring.jpa.entity.Product;
import com.spring.jpa.repository.ProductRepository;
import com.spring.jpa.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> addAllProduct(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public List<Product> findAllProductById(List<Long> id) {
        return productRepository.findAllById(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Long productCount() {
        return productRepository.count();
    }

    @Override
    public String deleteById(Long id) {
        productRepository.deleteById(id);
        return id+" deleted";
    }

    @Override
    public String deleteByProduct(Product product) {
        productRepository.delete(product);
        return product.getId()+" deleted";
    }

    @Override
    public String deleteAllById(List<Long> id) {
        productRepository.deleteAllById(id);
        return id+" All deleted";
    }

    @Override
    public String deleteAllByProduct(List<Product> products) {
        productRepository.deleteAll(products);

        return products+" deleted";
    }

    @Override
    public String deleteAll() {
        productRepository.deleteAll();
        return "All Product deleted";
    }

    @Override
    public Product updateProduct(Product product, Long id){
        if(productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    // Query finder method
    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findFirstByName(String name) {
        return productRepository.findFirstByName(name);
    }

    @Override
    public Product findLastByName(String name) {
        return productRepository.findLastByName(name);
    }

    // Use of @Query
    @Override
    public Product findByNameOrDesc(String name, String description) {
        return productRepository.findByProductOrDescription(name, description);
    }

    // Use of @NamedQuery
    @Override
    public Product findByPrice(BigDecimal price) {
        return productRepository.findByPrice(price);
    }

    // Pagination and sorting implementation
    @Override
    public List<Product> paginationAndSorting(int pageNo, int size, String sortBy){
        Pageable pageable = PageRequest.of(pageNo, size, Sort.by(sortBy).descending());
        Page<Product> products = productRepository.findAll(pageable);

        int totalPage = products.getTotalPages();
        long totalElements = products.getTotalElements();
        int numberOfElement = products.getNumberOfElements();
        int pageSize = products.getSize();
        boolean isLast = products.isLast();
        boolean isFirst = products.isFirst();
        System.out.println("Total Page : "+totalPage);
        System.out.println("Total Elements : "+totalElements);
        System.out.println("Total Elements in current page : "+numberOfElement);
        System.out.println("Page size : "+pageSize);
        System.out.println("Is Last Page : "+isLast);
        System.out.println("Is first Page : "+isFirst);

        return products.stream().toList();
    }
}
