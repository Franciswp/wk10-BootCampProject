package com.exercise.bootcampproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @Enumerated(EnumType.STRING)
    private Administration administration;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private ZonedDateTime createdAt = makeDate();

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    @LastModifiedDate
    private ZonedDateTime updatedAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bootcamp_id", referencedColumnName = "id")
    private BootCamp bootCamp;

    @ManyToMany(fetch = FetchType.EAGER) @JsonIgnore
    @JoinTable(name = "course_review",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> reviews = new ArrayList<>();

    /*public void addReview(Review review){
        reviews.add(review);
    }*/

    private ZonedDateTime makeDate(){
        ZonedDateTime date = ZonedDateTime.now();
        return date;
    }

    public ZonedDateTime modifyDate(){
        ZonedDateTime date = ZonedDateTime.now();
        return date;
    }
}
