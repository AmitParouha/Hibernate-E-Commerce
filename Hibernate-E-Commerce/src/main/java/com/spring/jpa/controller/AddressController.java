package com.spring.jpa.controller;

import com.spring.jpa.entity.Address;
import com.spring.jpa.entity.Order;
import com.spring.jpa.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<Address> placeOrder(@RequestBody Address address){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressRepository.save(address));
    }

    @PostMapping("/add/allAddress")
    public ResponseEntity<List<Address>> placeAllOrder(@RequestBody List<Address> addresses){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressRepository.saveAll(addresses));
    }

    @GetMapping("/getAllBy/{city}")
    public ResponseEntity<List<Address>> getAllByCity(@PathVariable String city){
        return ResponseEntity.ok(addressRepository.findAllByCity(city));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Address>> placeOrder(){
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @DeleteMapping("/deleteBy/{addressId}")
    public ResponseEntity<String> placeOrder(@PathVariable long addressId){
        if(addressRepository.existsById(addressId)) {
            addressRepository.deleteById(addressId);
            return ResponseEntity.status(HttpStatus.OK).body(addressId+" deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(addressId+" not found");
    }
}
