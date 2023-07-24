package com.exercise.bootcampproject.controller;

import com.exercise.bootcampproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserControllerInterface {
    User getUserById(long userId);
    List<User> getUserByAdministration(Optional<String> admins);
}
