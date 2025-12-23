package com.example.workoutlog.service;

import com.example.workoutlog.model.Exercise;
import com.example.workoutlog.repository.ExerciseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found"));
    }

    @Override
    public List<Exercise> getExercisesByWorkout(Long workoutId) {
        return exerciseRepository.findByWorkoutId(workoutId);
    }

    @Override
    public Exercise updateExercise(Long id, Exercise updatedExercise) {
        Exercise existing = getExerciseById(id);

        existing.setName(updatedExercise.getName());
        existing.setSets(updatedExercise.getSets());

        return exerciseRepository.save(existing);
    }

    @Override
    public void deleteExercise(Long id) {
        var doesExerciseExist = exerciseRepository.existsById(id);

        if (!doesExerciseExist) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise with ID " + id + " doesn't exist.");
        }

        exerciseRepository.deleteById(id);
    }
}
