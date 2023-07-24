package com.exercise.bootcampproject.controller;

import com.exercise.bootcampproject.model.Administration;
import com.exercise.bootcampproject.model.User;
import com.exercise.bootcampproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor @RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable(name = "id") long userId) {
        return userRepository.findById(userId).get();
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserByAdministration(@RequestParam(defaultValue = "student") Optional<String> administration) {
        if (administration.isPresent()) {
            return userRepository.findByAdministration(Administration.valueOf(administration.get().toUpperCase()));
        } else {
            List<User> users = userRepository.findAll();
            return users;
        }
    }

}
