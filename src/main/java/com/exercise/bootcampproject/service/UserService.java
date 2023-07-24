package com.exercise.bootcampproject.service;

import com.exercise.bootcampproject.model.User;
import com.exercise.bootcampproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User addNewUser(User user){
        return userRepository.save(user);
    }
}
