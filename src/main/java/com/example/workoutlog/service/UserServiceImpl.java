package com.example.workoutlog.service;

import com.example.workoutlog.model.User;
import com.example.workoutlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
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

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + id + " already exists!");
        }

        return userOptional.get();
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
        user.setWorkouts(updatedUser.getWorkouts());

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
