package com.example.workoutlog.repository;

import com.example.workoutlog.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    // exercises belong to a workout
    List<Exercise> findByWorkoutId(Long workoutId);

    // find exercises by the workout they are in and by their name
    List<Exercise> findByWorkoutIdAndName(Long workoutId, String name);

}
