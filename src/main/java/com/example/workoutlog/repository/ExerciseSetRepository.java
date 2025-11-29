package com.example.workoutlog.repository;

import com.example.workoutlog.model.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {

    // a set -> reps + weight
    // a set belongs to an exercise, which is found in a workout
    List<ExerciseSet> findByExerciseId(Long exerciseId);

    // get total volume moved in a single workout (total lbs moved)
    @Query("""
            SELECT SUM(s.weight * s.reps)
            FROM ExerciseSet s
            WHERE s.exercise.id = :exerciseId
            """)
    Integer getTotalVolumeForExercise(Long exerciseId);

    // find the total sets that were done in a single workout
    @Query("""
            SELECT COUNT(s)
            FROM ExerciseSet s
            JOIN s.exercise e
            WHERE e.workout.id = :workoutId
            """)
    int countSetsForWorkout(Long workoutId);

}
