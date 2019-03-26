package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.ExerciseSet;

import java.util.List;

public class GetExerciseDurationService {

    public static int getExerciseDurationTime(Exercise exercise) {

        int overallDurationTime = 0;
        int currentSetDurationTime = 0;

        List<ExerciseSet> exerciseSets = exercise.getSets();

        for (ExerciseSet exerciseSet : exerciseSets) {

            currentSetDurationTime = exerciseSet.getSetTime();
            overallDurationTime = overallDurationTime + currentSetDurationTime;
        }

        return overallDurationTime;
    }

}
