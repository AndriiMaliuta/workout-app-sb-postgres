package com.bh.workouts.bhworkoutapp.services.helpers;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;

import java.util.ArrayList;
import java.util.List;

public class GetSpecificUserWorkoutsService {

    public static List<Workout> userWorkouts(List<Workout> workouts, User userLogin) {

        List<Workout> userWorkouts = new ArrayList<>();

        for (Workout workout : workouts) {

            if (workout.getUser().equals(userLogin)) {
                userWorkouts.add(workout);
            }
        }

        return userWorkouts;
    }
}
