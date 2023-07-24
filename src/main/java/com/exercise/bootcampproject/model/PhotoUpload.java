package com.exercise.bootcampproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class PhotoUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @OneToOne(mappedBy = "photoUpload",fetch = FetchType.LAZY)
    private User user;
}
