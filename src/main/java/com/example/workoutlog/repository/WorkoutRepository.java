package com.example.workoutlog.repository;

import com.example.workoutlog.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
interface WorkoutRepository extends JpaRepository<Workout, Long> {

    // finds workouts by user id, since workouts belong to users
    List<Workout> findByUserId(Long userId);

    // finds workouts on a specific day
    List<Workout> findByUserIdAndWorkoutDate(Long userId, LocalDate date);

    // gets the total number of workouts completed by the user in the current month/year
    @Query("""
            SELECT COUNT(w)
            FROM Workout w
            WHERE w.user.id = :userId
              AND MONTH(w.workoutDate) = MONTH(CURRENT_DATE)
              AND YEAR(w.workoutDate) = YEAR(CURRENT_DATE)
            """)
    int getMonthlyWorkoutCount(Long userId);

}
