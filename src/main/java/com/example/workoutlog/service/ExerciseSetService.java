package com.example.workoutlog.service;

import com.example.workoutlog.model.ExerciseSet;

import java.util.List;

public interface ExerciseSetService {

    ExerciseSet createExerciseSet(ExerciseSet exerciseSet);

    ExerciseSet getExerciseSetById(Long id);

    List<ExerciseSet> getSetsByExercise(Long exerciseId);

    ExerciseSet updateExerciseSet(Long id, ExerciseSet updatedExerciseSet);

    void deleteExerciseSet(Long id);
}
