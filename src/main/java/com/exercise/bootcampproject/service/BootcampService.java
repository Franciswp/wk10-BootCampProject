package com.exercise.bootcampproject.service;

import com.exercise.bootcampproject.model.BootCamp;
import com.exercise.bootcampproject.model.Course;
import com.exercise.bootcampproject.model.Review;
import com.exercise.bootcampproject.model.User;
import com.exercise.bootcampproject.repository.BootcampRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class BootcampService {
    private final BootcampRepository bootcampRepository;

    @Transactional
    public BootCamp addBootCamp(BootCamp bootCamp){
        return bootcampRepository.save(bootCamp);
    }

    public List<BootCamp> findAll(Optional<String> location) {
        if (location.isPresent()) {
            return bootcampRepository.findAllByLocation(location.get());
        }
        return bootcampRepository.findAll();
    }

    public BootCamp findById(Long id) {
        return bootcampRepository.findById(id).orElseThrow();
    }

    @Transactional
    public BootCamp addReview(Long id, Review review) {
        BootCamp bootCamp = bootcampRepository.findById(id).orElseThrow();
        bootCamp.addReview(review);
        return bootcampRepository.save(bootCamp);
    }

    @Transactional
    public BootCamp addCourse(Long id, Course course) {
        BootCamp bootCamp = bootcampRepository.findById(id).orElseThrow();
        bootCamp.addCourse(course);
        return bootcampRepository.save(bootCamp);
    }

    @Transactional
    public BootCamp addUser(Long id, User user) {
        BootCamp bootCamp = bootcampRepository.findById(id).orElseThrow();
        bootCamp.addUser(user);
        return bootcampRepository.save(bootCamp);
    }


}
