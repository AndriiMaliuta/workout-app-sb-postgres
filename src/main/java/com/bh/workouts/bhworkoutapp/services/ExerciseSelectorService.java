package com.bh.workouts.bhworkoutapp.services;

import java.util.ArrayList;
import java.util.List;

public class ExerciseSelectorService {

    public static List<String> getExercisesList(String workoutType) {

        List<String> defList = new ArrayList<>();
        List<String> bicepsExercisesList = new ArrayList<>();
        List<String> backExercisesList = new ArrayList<>();
        List<String> pecsExercisesList = new ArrayList<>();
        List<String> tricepsExercisesList = new ArrayList<>();
        List<String> deltsExercisesList = new ArrayList<>();

        if (workoutType.equalsIgnoreCase("BICEPS")) {

            bicepsExercisesList.add("Incline Dumbbell Hammer Curl");
            bicepsExercisesList.add("Incline Inner-Biceps Curl");
            bicepsExercisesList.add("Standing Concentration Dumbbell Curl");
            bicepsExercisesList.add("EZ-Bar Curl");
            bicepsExercisesList.add("Wide-Grip Standing Barbell Curl");

            return bicepsExercisesList;

        } else if (workoutType.equalsIgnoreCase("PECS")) {

            pecsExercisesList.add("Barbell Bench Press");
            pecsExercisesList.add("Incline Bench Press");
            pecsExercisesList.add("Hammer Flat Bench Press");
            pecsExercisesList.add("Hammer Incline Bench Press");
            pecsExercisesList.add("Dumb-bells Flat Bench Press");
            pecsExercisesList.add("Dumb-bells Incline Bench Press");

            return pecsExercisesList;

        } else if (workoutType.equalsIgnoreCase("TRICEPS")) {

            tricepsExercisesList.add("Barbell Flat Bench Press Narrow-Grip");
            tricepsExercisesList.add("Standing Barbell Triceps Extensions");
            tricepsExercisesList.add("1-Dumbbell Triceps Extensions");
            tricepsExercisesList.add("Pulley Push-Downs");
            tricepsExercisesList.add("Lying Barbell Triceps Extensions");

            return tricepsExercisesList;

        } else if (workoutType.equalsIgnoreCase("BACK")) {

            backExercisesList.add("Barbell Deadlift");
            backExercisesList.add("Bent-Over Barbell Deadlift");
            backExercisesList.add("Wide-Grip Pull-Up");
            backExercisesList.add("Standing T-Bar Row");
            backExercisesList.add("Wide-Grip Seated Cable Row");

            return backExercisesList;

        } else if (workoutType.equalsIgnoreCase("DELTS")) {

            deltsExercisesList.add("Bar Press Sitting");
            deltsExercisesList.add("Kettlebell Pull to Chin");
            deltsExercisesList.add("Dumbbells Press Sitting");
            deltsExercisesList.add("Kettlebell Press");
            deltsExercisesList.add("Barbell Pull to Chin");

            return deltsExercisesList;
        }

        return defList;

    }

}
