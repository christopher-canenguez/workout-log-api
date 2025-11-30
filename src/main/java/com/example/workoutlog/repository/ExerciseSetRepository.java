package com.example.workoutlog.repository;

import com.example.workoutlog.model.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {

    // a set -> reps + weight
    // a set belongs to an exercise, which is found in a workout
    List<ExerciseSet> findByExerciseId(Long exerciseId);

}
