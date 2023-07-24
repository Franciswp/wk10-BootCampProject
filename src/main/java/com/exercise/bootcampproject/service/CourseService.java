package com.exercise.bootcampproject.service;

import com.exercise.bootcampproject.model.BootCamp;
import com.exercise.bootcampproject.model.Course;
import com.exercise.bootcampproject.model.Review;
import com.exercise.bootcampproject.repository.CourseRepository;
import com.exercise.bootcampproject.repository.ReviewRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;

    public List<Course> findAll(Optional<String> courseName) {
        if (courseName.isPresent()) {
            return courseRepository.findAllByCourseName(courseName.get());
        }
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Course addReview(Long id, Review review) {
        Course course = courseRepository.findById(id).get();
        course.getReviews().add(review);
        return courseRepository.save(course);
    }

    @Transactional
    public Review addCourse(Long id, Course course){
        Review review = reviewRepository.findById(id).get();
        review.getCourses().add(course);
        return reviewRepository.save(review);
    }

    public Map<String, Boolean> deleteCourse(Long id) throws Exception {
        Course course =
                courseRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));

        courseRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("You have deleted a Course", Boolean.TRUE);
        return response;
    }

    @Transactional @JsonIgnore
    public ResponseEntity<Course> updateCourse(Long id, Course courseDetails)
            throws ResourceNotFoundException {

        Course course =
                courseRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Course not found on :: " + id));

        course.setCourseName(courseDetails.getCourseName());
        course.setCourseCode(courseDetails.getCourseCode());
        course.setAdministration(courseDetails.getAdministration());
        course.setUpdatedAt(course.modifyDate());
        final Course updatedCourse = courseRepository.save(course);
        return ResponseEntity.ok(updatedCourse);
    }

}
