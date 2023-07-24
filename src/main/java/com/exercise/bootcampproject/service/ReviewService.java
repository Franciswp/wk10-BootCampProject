package com.exercise.bootcampproject.service;

import com.exercise.bootcampproject.model.Review;
import com.exercise.bootcampproject.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public Review addNewReview(Review review){
        return reviewRepository.save(review);
    }
}
