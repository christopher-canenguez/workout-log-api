package com.example.workoutlog.service;

import com.example.workoutlog.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User updatedUser);

    void deleteUser(Long id);

    boolean emailExists(String email);

}
