package com.example.workoutlog.controller;

import com.example.workoutlog.model.ExerciseSet;
import com.example.workoutlog.service.ExerciseSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sets")
public class ExerciseSetController {

    private final ExerciseSetService exerciseSetService;

    @Autowired
    public ExerciseSetController(ExerciseSetService exerciseSetService) {
        this.exerciseSetService = exerciseSetService;
    }

    @PostMapping
    public ResponseEntity<ExerciseSet> create(@RequestBody ExerciseSet exerciseSet) {
        return ResponseEntity.ok(exerciseSetService.createExerciseSet(exerciseSet));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseSet> getById(@PathVariable Long id) {
        return ResponseEntity.ok(exerciseSetService.getExerciseSetById(id));
    }

    @GetMapping("/exercise/{exerciseId}")
    public ResponseEntity<List<ExerciseSet>> getByExercise(@PathVariable Long exerciseId) {
        return ResponseEntity.ok(exerciseSetService.getSetsByExercise(exerciseId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseSet> update(
            @PathVariable Long id,
            @RequestBody ExerciseSet updatedExerciseSet
    ) {
        return ResponseEntity.ok(exerciseSetService.updateExerciseSet(id, updatedExerciseSet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exerciseSetService.deleteExerciseSet(id);
        return ResponseEntity.noContent().build();
    }
}
