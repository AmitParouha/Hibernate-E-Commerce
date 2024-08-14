package com.spring.jpa.repository;

import com.spring.jpa.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {

    public List<Reviews> findByProductIdOrderByProductNameDesc(int productId);
    public Reviews findDistinctByRating(int productId);
    public List<Reviews> findByRatingGreaterThan(int rating);
    public List<Reviews> findByRatingLessThan(int rating);
    public List<Reviews> findByProductNameContaining(String criteria);
    public List<Reviews> findByRatingBetween(int startRating, int endRating);
    public List<Reviews> findTop3ByRating( int rating);

}
