package com.example.workoutlog.service;

import com.example.workoutlog.model.Workout;
import com.example.workoutlog.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public Workout getWorkoutById(Long id) {
        Optional<Workout> workoutOptional = workoutRepository.findById(id);

        if (workoutOptional.isEmpty()) {
            throw new IllegalStateException("Workout with Id " + id + " does not exist.");
        }

        return workoutOptional.get();
    }

    @Override
    public List<Workout> getWorkoutsByUserId(Long userId) {
        return workoutRepository.findByUserId(userId);
    }

    @Override
    public Workout updateWorkout(Long id, Workout updatedWorkout) {
        Workout existingWorkout = getWorkoutById(id);

        existingWorkout.setDate(updatedWorkout.getDate());
        existingWorkout.setNotes(updatedWorkout.getNotes());
        existingWorkout.setExercises(updatedWorkout.getExercises());
        existingWorkout.setDuration(updatedWorkout.getDuration());

        return workoutRepository.save(existingWorkout);
    }

    @Override
    public void deleteWorkout(Long id) {
        boolean doesWorkoutExist = workoutRepository.existsById(id);

        if (!doesWorkoutExist) {
            throw new IllegalStateException("Workout with Id " + id + " does not exist.");
        }

        workoutRepository.deleteById(id);
    }
}
