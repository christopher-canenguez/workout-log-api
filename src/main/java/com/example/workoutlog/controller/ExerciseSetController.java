package com.example.workoutlog.controller;

import com.example.workoutlog.model.ExerciseSet;
import com.example.workoutlog.service.ExerciseSetService;
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
@RequestMapping("/api/sets")
public class ExerciseSetController {

    private final ExerciseSetService exerciseSetService;

    public ExerciseSetController(ExerciseSetService exerciseSetService) {
        this.exerciseSetService = exerciseSetService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExerciseSet> create(@Valid @RequestBody ExerciseSet exerciseSet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseSetService.createExerciseSet(exerciseSet));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExerciseSet> getById(@PathVariable Long id) {
        return ResponseEntity.ok(exerciseSetService.getExerciseSetById(id));
    }

    @GetMapping("/exercise/{exerciseId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ExerciseSet>> getByExercise(@PathVariable Long exerciseId) {
        return ResponseEntity.ok(exerciseSetService.getSetsByExercise(exerciseId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExerciseSet> update(
            @PathVariable Long id,
            @Valid @RequestBody ExerciseSet updatedExerciseSet
    ) {
        return ResponseEntity.ok(exerciseSetService.updateExerciseSet(id, updatedExerciseSet));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exerciseSetService.deleteExerciseSet(id);
        return ResponseEntity.noContent().build();
    }
}
