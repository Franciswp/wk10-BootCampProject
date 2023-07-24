package com.exercise.bootcampproject.repository;

import com.exercise.bootcampproject.model.BootCamp;
import com.exercise.bootcampproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByCourseName(String courseName);
}
