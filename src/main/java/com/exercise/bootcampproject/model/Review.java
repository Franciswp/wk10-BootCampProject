package com.exercise.bootcampproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data @Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String userName;
    private String comment;
    private int rating;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bootcamp_id", referencedColumnName = "id")
    private BootCamp bootCamp;

    @ManyToMany(mappedBy = "reviews",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    public void addCourseToReview(Course course){
        courses.add(course);
        course.getReviews();
    }
}
