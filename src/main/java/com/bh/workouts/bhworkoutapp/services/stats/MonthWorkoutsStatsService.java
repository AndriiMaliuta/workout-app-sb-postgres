package com.bh.workouts.bhworkoutapp.services.stats;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;

import java.util.ArrayList;
import java.util.List;

public class MonthWorkoutsStatsService {

    private final WorkoutRepository workoutRepository;

    public MonthWorkoutsStatsService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public int getWorkoutsNumberByType(String month, String workoutType) {

        List<Workout> allWorkouts = workoutRepository.findAll();
        List<Workout> workoutsByType = new ArrayList<>();

        for (Workout workout : allWorkouts) {

            if (workout.getWorkoutMonth().equals(month) && workout.getWorkoutType().equals(workoutType)) {

                workoutsByType.add(workout);

            }
        }

        return workoutsByType.size();
    }
}