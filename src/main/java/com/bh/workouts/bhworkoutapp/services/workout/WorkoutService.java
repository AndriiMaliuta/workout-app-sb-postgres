package com.bh.workouts.bhworkoutapp.services.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;

import java.util.List;

public interface WorkoutService {

    List<Workout> findAllWorkouts();
    List<Workout> findWorkoutsByWorkoutDay(String day);
    List<Workout> findWorkoutByWorkoutDate(String date);
    List<Workout> userWorkouts(List<Workout> workouts, User userLogin);
    List<Workout> getWorkoutsByYear(List<Workout> workouts, int year);
    List<Workout> getWorkoutsByYearMonth(List<Workout> workouts, int year, String month);
    List<Workout> getWorkoutsByYearMonthWeek(List<Workout> workouts, int year, String month, Integer week);

}
