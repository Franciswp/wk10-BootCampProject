package com.exercise.bootcampproject.controller;

import com.exercise.bootcampproject.model.BootCamp;
import com.exercise.bootcampproject.model.Course;
import com.exercise.bootcampproject.model.Review;
import com.exercise.bootcampproject.model.User;
import com.exercise.bootcampproject.service.BootcampService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor @RequestMapping("bootcamp")
public class BootcampController {
    private final BootcampService bootcampService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BootCamp> getAllBootCamps(@RequestParam Optional<String> location) {
        return bootcampService.findAll(location);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BootCamp getBootcampById(@PathVariable Long id) {
        return bootcampService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BootCamp createBootCamp(@RequestBody BootCamp bootCamp){
        return bootcampService.addBootCamp(bootCamp);
    }

    @PostMapping("/{id}/reviews")
    @ResponseStatus(HttpStatus.OK)
    public BootCamp addReview(@PathVariable Long id, @RequestBody Review review){
        return bootcampService.addReview(id, review);
    }

    @PostMapping("/{id}/courses")
    @ResponseStatus(HttpStatus.OK)
    public BootCamp addCourse(@PathVariable Long id, @RequestBody Course course){
        return bootcampService.addCourse(id, course);
    }

    @PostMapping("/{id}/users")
    @ResponseStatus(HttpStatus.OK)
    public BootCamp addUser(@PathVariable Long id, @RequestBody User user){
        return bootcampService.addUser(id, user);
    }

}
