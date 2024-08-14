package com.spring.jpa.controller;

import com.spring.jpa.entity.Reviews;
import com.spring.jpa.repository.ReviewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private ReviewsRepository repository;

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Reviews reviews){
        repository.save(reviews);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Product "+reviews.getProductName()+" review added");
    }

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<Reviews>> getReviewInDescendingOrder(@PathVariable int productId){
        return ResponseEntity.ok(repository.findByProductIdOrderByProductNameDesc(productId));
    }

    @GetMapping("/distinct/{productId}")
    public ResponseEntity<Reviews> getDistinctByRating(@PathVariable int productId){
        return ResponseEntity.ok(repository.findDistinctByRating(productId));
    }

    @GetMapping("/greater/{rating}")
    public ResponseEntity<List<Reviews>> getReviewsGreaterThan(@PathVariable int rating){
        return ResponseEntity.ok(repository.findByRatingGreaterThan(rating));
    }

    @GetMapping("/less/{rating}")
    public ResponseEntity<List<Reviews>> getReviewsLessThan(@PathVariable int rating){
        return ResponseEntity.ok(repository.findByRatingLessThan(rating));
    }

    @GetMapping("/isHaving/{constraint}")
    public ResponseEntity<List<Reviews>> getReviewsLessThan(@PathVariable String constraint){
        return ResponseEntity.ok(repository.findByProductNameContaining(constraint));
    }

    @GetMapping("/between/{start}/{end}")
    public ResponseEntity<List<Reviews>> getReviewsBetween(@PathVariable int start,
                                                           @PathVariable int end){
        return ResponseEntity.ok(repository.findByRatingBetween(start, end));
    }

    @GetMapping("/top3/{rating}")
    public ResponseEntity<List<Reviews>> getTop3Reviews(@PathVariable int rating){
        return ResponseEntity.ok(repository.findTop3ByRating(rating));
    }
}
