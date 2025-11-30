package com.example.workoutlog.repository;

import com.example.workoutlog.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    // finds workouts by user id, since workouts belong to users
    List<Workout> findByUserId(Long userId);

}
