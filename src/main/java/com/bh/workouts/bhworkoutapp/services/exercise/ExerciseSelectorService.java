package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;

import java.util.ArrayList;
import java.util.List;

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
