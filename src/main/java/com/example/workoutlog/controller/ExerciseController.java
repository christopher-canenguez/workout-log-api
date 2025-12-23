package com.example.workoutlog.controller;

import com.example.workoutlog.model.Exercise;
import com.example.workoutlog.service.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Exercise> create(@Valid @RequestBody Exercise exercise) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseService.createExercise(exercise));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Exercise> getById(@PathVariable Long id) {
        return ResponseEntity.ok(exerciseService.getExerciseById(id));
    }

    @GetMapping("/workout/{workoutId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Exercise>> getByWorkout(@PathVariable Long workoutId) {
        return ResponseEntity.ok(exerciseService.getExercisesByWorkout(workoutId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Exercise> update(@PathVariable Long id, @Valid @RequestBody Exercise updatedExercise) {
        return ResponseEntity.ok(exerciseService.updateExercise(id, updatedExercise));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}
