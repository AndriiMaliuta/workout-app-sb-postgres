package com.bh.workouts.bhworkoutapp.services.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;

import java.util.List;

public interface WorkoutService {

    List<Workout> findWorkoutsByWorkoutDay(String day);
    List<Workout> findWorkoutByWorkoutDate(String date);

}
