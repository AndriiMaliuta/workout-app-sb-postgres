package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.ExerciseSet;
import com.bh.workouts.bhworkoutapp.models.Workout;

import java.util.List;

public class GetSetsForWorkoutService {

    public static int getWorkoutSets(Workout workout) {

        int currentSetsCount = 0;
        int allSetsCount = 0;

        List<Exercise> exercises = workout.getExercises();

        for (Exercise exercise : exercises) {
            List<ExerciseSet> exerciseSets = exercise.getSets();
            currentSetsCount = exerciseSets.size();
            allSetsCount = allSetsCount + currentSetsCount;
        }

        return allSetsCount;

    }
}