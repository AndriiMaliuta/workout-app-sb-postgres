package com.bh.workouts.bhworkoutapp.services.stats;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.GetSpecificUserWorkoutsService;

import java.util.ArrayList;
import java.util.List;

public class MonthWorkoutsStatsService {

    private final WorkoutRepository workoutRepository;

    public MonthWorkoutsStatsService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public int getWorkoutsNumberByType(String month, String workoutType, User user) {

        List<Workout> userWorkouts = GetSpecificUserWorkoutsService.userWorkouts(workoutRepository.findAll(), user);

        List<Workout> workoutsByType = new ArrayList<>();

        for (Workout workout : userWorkouts) {

            if (workout.getWorkoutMonth().equalsIgnoreCase(month)
                    && workout.getWorkoutType().equalsIgnoreCase(workoutType)) {

                workoutsByType.add(workout);

            }
        }

        return workoutsByType.size();
    }
}