package com.exercise.bootcampproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor
@Entity
public class BootCamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bootcamp_name")
    private  String name;

    @Column(name = "continent")
    private String location;

    @Column(name = "capital_city")
    private String city;

    @OneToMany(mappedBy = "bootCamp",cascade = CascadeType.ALL, orphanRemoval = true,
    fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "bootCamp",cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "bootCamp",cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    public BootCamp(String name, String location, String city) {
        this.name = name;
        this.location = location;
        this.city = city;
    }

    public  void addCourse(Course course){
        courses.add(course);
        course.setBootCamp(this);
    }

    public void addUser(User user){
        users.add(user);
        user.setBootCamp(this);
    }

    public void addReview(Review review){
        reviews.add(review);
        review.setBootCamp(this);
    }
}
