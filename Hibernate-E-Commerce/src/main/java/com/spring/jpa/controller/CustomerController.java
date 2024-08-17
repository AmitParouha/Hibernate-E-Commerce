package com.spring.jpa.controller;

import com.spring.jpa.entity.Customer;
import com.spring.jpa.entity.Order;
import com.spring.jpa.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.save(customer));
    }

    @PostMapping("/addAll/customer")
    public ResponseEntity<List<Customer>> addAllCustomer(@RequestBody List<Customer> customers){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.saveAll(customers));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @DeleteMapping("/deleteBy/{email}")
    public ResponseEntity<String> deleteCustomerByEmail(@PathVariable String email){
        if(customerRepository.existsByEmail(email)) {
            customerRepository.deleteByEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(email+" deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(email+" not found");
    }
}
