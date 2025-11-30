package com.example.workoutlog.service;

import com.example.workoutlog.model.User;
import com.example.workoutlog.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        if (emailExists(user.getEmail())) {
            throw new IllegalArgumentException("Email already in use!");
        }

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID " + id + " does not exist!"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User updatedUser) {

        var user = getUserById(id);

        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        boolean doesUserExist = userRepository.existsById(id);

        if (!doesUserExist) {
            throw new IllegalArgumentException("User with ID " + id + " doesn't exist.");
        }

        userRepository.deleteById(id);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
