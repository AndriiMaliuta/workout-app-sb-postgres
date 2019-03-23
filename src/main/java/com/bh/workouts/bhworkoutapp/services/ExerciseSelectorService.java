package com.bh.workouts.bhworkoutapp.services;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseSelectorService {

    public static List<ExerciseName> getExercisesList(List<ExerciseName> list, String workoutType, User user) {

        List<ExerciseName> userWorkoutTypeExercisesList = new ArrayList<>();

        for (ExerciseName exerciseName : list) {
            if (exerciseName.getCategory().equalsIgnoreCase(workoutType)
                    && exerciseName.getUser().equals(user)) {

                userWorkoutTypeExercisesList.add(exerciseName);
            }
        }

        return userWorkoutTypeExercisesList;

    }

}
