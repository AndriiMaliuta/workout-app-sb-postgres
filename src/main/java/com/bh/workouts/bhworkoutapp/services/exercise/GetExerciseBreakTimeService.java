package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.ExerciseSet;

import java.util.List;

public class GetExerciseBreakTimeService {

    public static int getExerciseBreakTime(Exercise exercise) {

        int overallBreakTime = 0;
        int currentSetBreakTime = 0;

        List<ExerciseSet> exerciseSets = exercise.getSets();

        for (ExerciseSet exerciseSet : exerciseSets) {

            currentSetBreakTime = exerciseSet.getBreakInSeconds();
            overallBreakTime = overallBreakTime + currentSetBreakTime;
        }

        return overallBreakTime;
    }
}
