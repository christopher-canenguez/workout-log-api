package com.example.workoutlog.service;

import com.example.workoutlog.model.Exercise;

import java.util.List;

public interface ExerciseService {

    Exercise createExercise(Exercise exercise);

    Exercise getExerciseById(Long id);

    List<Exercise> getExercisesByWorkout(Long workoutId);

    Exercise updateExercise(Long id, Exercise updatedExercise);

    void deleteExercise(Long id);
}
