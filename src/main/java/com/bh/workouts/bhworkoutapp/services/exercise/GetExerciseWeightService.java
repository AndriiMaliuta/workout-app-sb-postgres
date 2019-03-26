package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.ExerciseSet;

import java.util.List;

public class GetExerciseWeightService {

    public static int getExerciseOverallWeight(Exercise exercise) {

        int overallWeightsCount = 0;
        int currentSetWights = 0;

        List<ExerciseSet> exerciseSets = exercise.getSets();

        for (ExerciseSet exerciseSet : exerciseSets) {

            currentSetWights = exerciseSet.getWeight();
            overallWeightsCount = overallWeightsCount + currentSetWights;
        }

        return overallWeightsCount;
    }
}
