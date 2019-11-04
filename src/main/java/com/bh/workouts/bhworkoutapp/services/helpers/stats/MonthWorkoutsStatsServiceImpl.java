package com.bh.workouts.bhworkoutapp.services.helpers.stats;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.helpers.GetSpecificUserWorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonthWorkoutsStatsServiceImpl implements MonthWorkoutsStatsService {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public MonthWorkoutsStatsServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
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
