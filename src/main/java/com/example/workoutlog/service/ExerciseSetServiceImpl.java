package com.example.workoutlog.service;

import com.example.workoutlog.model.ExerciseSet;
import com.example.workoutlog.repository.ExerciseSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseSetServiceImpl implements ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;

    @Autowired
    public ExerciseSetServiceImpl(ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    @Override
    public ExerciseSet createExerciseSet(ExerciseSet exerciseSet) {
        return exerciseSetRepository.save(exerciseSet);
    }

    @Override
    public ExerciseSet getExerciseSetById(Long id) {
        return exerciseSetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ExerciseSet not found"));
    }

    @Override
    public List<ExerciseSet> getSetsByExercise(Long exerciseId) {
        return exerciseSetRepository.findByExerciseId(exerciseId);
    }

    @Override
    public ExerciseSet updateExerciseSet(Long id, ExerciseSet updatedExerciseSet) {
        ExerciseSet existing = getExerciseSetById(id);

        existing.setReps(updatedExerciseSet.getReps());
        existing.setWeight(updatedExerciseSet.getWeight());
        existing.setNotes(updatedExerciseSet.getNotes());

        return exerciseSetRepository.save(existing);
    }

    @Override
    public void deleteExerciseSet(Long id) {
        exerciseSetRepository.deleteById(id);
    }
}