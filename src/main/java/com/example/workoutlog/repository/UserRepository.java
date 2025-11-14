package com.example.workoutlog.repository;

import com.example.workoutlog.model.User;
import com.example.workoutlog.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface UserRepository extends JpaRepository<User, Long> {

    // finds user via their email
    Optional<User> findByEmail(String email);

    @Query("SELECT w FROM Workout w WHERE w.user.id = :userId")
    List<Workout> findAllWorkoutsByUser(Long userId);

}
