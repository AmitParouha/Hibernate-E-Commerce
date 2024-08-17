package com.spring.jpa.repository;

import com.spring.jpa.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    public Order findByOrderTrackingNumber(String orderTrackingNumber);

    @Transactional
    public void deleteByOrderTrackingNumber(String orderTrackingNumber);
}
