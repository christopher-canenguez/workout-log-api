package com.example.workoutlog.service;

import com.example.workoutlog.model.Workout;

import java.util.List;

interface WorkoutService {

    Workout createWorkout(Workout workout);

    Workout getWorkoutById(Long id);

    List<Workout> getWorkoutsByUserId(Long userId);

    Workout updateWorkout(Long id, Workout updatedWorkout);

    void deleteWorkout(Long id);
}
