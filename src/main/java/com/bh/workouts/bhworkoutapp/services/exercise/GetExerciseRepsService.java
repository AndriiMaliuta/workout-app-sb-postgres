package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.ExerciseSet;

import java.util.List;

public class GetExerciseRepsService {

    public static int getExerciseReps(Exercise exercise) {

        int overallRepsCount = 0;
        int currentSetRepsCount = 0;

        List<ExerciseSet> exerciseSets = exercise.getSets();

        for (ExerciseSet exerciseSet : exerciseSets) {

            currentSetRepsCount = exerciseSet.getReps();
            overallRepsCount = overallRepsCount + currentSetRepsCount;
        }

        return overallRepsCount;
    }
}
