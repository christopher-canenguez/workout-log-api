package com.example.workoutlog.repository;

import com.example.workoutlog.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    // exercises belong to a workout
    List<Exercise> findByWorkoutId(Long workoutId);

    // find exercises by the workout they are in and by their name
    List<Exercise> findByWorkoutIdAndName(Long workoutId, String name);

    // find all the exercises that a user has done ever
    @Query("""
            SELECT e FROM Exercise e
            JOIN e.workout w
            WHERE w.user.id = :userId
            """)
    List<Exercise> findAllForUser(Long userId);

}
