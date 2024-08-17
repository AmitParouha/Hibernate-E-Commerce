package com.spring.jpa.controller;

import com.spring.jpa.entity.Address;
import com.spring.jpa.entity.User;
import com.spring.jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    @PostMapping("/addUsers")
    public ResponseEntity<List<User>> addAllUsers(@RequestBody List<User> users){
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.saveAll(users));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getAllByCity(@PathVariable String email){
        return ResponseEntity.ok(userRepository.findByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<User>> placeOrder(){
        return ResponseEntity.ok(userRepository.findAll());
    }

}
