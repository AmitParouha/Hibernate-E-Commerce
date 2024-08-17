package com.spring.jpa.controller;

import com.spring.jpa.entity.Order;
import com.spring.jpa.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private OrderRepository orderRepository;

    @PostMapping("/place/order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderRepository.save(order));
    }

    @PostMapping("/placeAll/order")
    public ResponseEntity<List<Order>> placeAllOrder(@RequestBody List<Order> orders){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderRepository.saveAll(orders));
    }

    @GetMapping("/getBy/trackingNumber/{trackingNumber}")
    public ResponseEntity<Order> getOrderByTrackingNumber(@PathVariable String trackingNumber){
        return ResponseEntity.ok(orderRepository.findByOrderTrackingNumber(trackingNumber));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Order>> placeOrder(){
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @DeleteMapping("/deleteBy/{trackingNumber}")
    public ResponseEntity<String> placeOrder(@PathVariable String trackingNumber){
        if(orderRepository.findByOrderTrackingNumber(trackingNumber)!=null) {
            orderRepository.deleteByOrderTrackingNumber(trackingNumber);
            return ResponseEntity.status(HttpStatus.OK).body(trackingNumber+" deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(trackingNumber+" not found");
    }
}
