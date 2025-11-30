package com.example.workoutlog.repository;

import com.example.workoutlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // finds user via their email
    Optional<User> findByEmail(String email);

}
