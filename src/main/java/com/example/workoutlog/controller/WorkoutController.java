package com.example.workoutlog.controller;

import com.example.workoutlog.model.Workout;
import com.example.workoutlog.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        return ResponseEntity.ok(workoutService.createWorkout(workout));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkout(@PathVariable Long id) {
        return ResponseEntity.ok(workoutService.getWorkoutById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Workout>> getWorkoutByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(workoutService.getWorkoutsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id,
                                                 @RequestBody Workout updatedWorkout) {
        return ResponseEntity.ok(workoutService.updateWorkout(id, updatedWorkout));
    }
}
