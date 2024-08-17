package com.spring.jpa.repository;

import com.spring.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public boolean existsByEmail(String email);
    public void deleteByEmail(String email);
}
