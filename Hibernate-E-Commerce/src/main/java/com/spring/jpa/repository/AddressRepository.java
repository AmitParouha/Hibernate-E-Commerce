package com.spring.jpa.repository;

import com.spring.jpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findAllByCity(String city);
}
