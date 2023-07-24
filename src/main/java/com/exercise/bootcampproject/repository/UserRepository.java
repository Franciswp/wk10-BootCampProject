package com.exercise.bootcampproject.repository;

import com.exercise.bootcampproject.model.Administration;
import com.exercise.bootcampproject.model.BootCamp;
import com.exercise.bootcampproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByAdministration(Administration administration);
}
