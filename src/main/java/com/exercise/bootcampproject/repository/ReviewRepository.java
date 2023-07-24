package com.exercise.bootcampproject.repository;

import com.exercise.bootcampproject.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
