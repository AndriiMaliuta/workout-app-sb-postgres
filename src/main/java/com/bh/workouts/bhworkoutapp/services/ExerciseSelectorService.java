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
        List<String> absExercisesList = new ArrayList<>();
        List<String> trapsExercisesList = new ArrayList<>();
        List<String> forearmsExercisesList = new ArrayList<>();


        if (workoutType.equalsIgnoreCase("BICEPS")) {

            bicepsExercisesList.add("Incline Dumbbell Hammer Curl");
            bicepsExercisesList.add("Incline Inner-Biceps Curl");
            bicepsExercisesList.add("Standing Concentration Dumbbell Curl");
            bicepsExercisesList.add("EZ-Bar Curl");
            bicepsExercisesList.add("Wide-Grip Standing Barbell Curl");
            bicepsExercisesList.add("Zottman Curl");
            bicepsExercisesList.add("Regular-Grip Barbell Curl 1 Hand");
            bicepsExercisesList.add("Regular-Grip Barbell Curl 2 Hands");
            bicepsExercisesList.add("Dumbbell Biceps Curl");
            bicepsExercisesList.add("Hammer Curl");
            bicepsExercisesList.add("Overhead Cable Curl");

            return bicepsExercisesList;

        } else if (workoutType.equalsIgnoreCase("PECS")) {

            pecsExercisesList.add("Barbell Bench Press");
            pecsExercisesList.add("Incline Bench Press");
            pecsExercisesList.add("Decline Bench Press");
            pecsExercisesList.add("Hammer Flat Bench Press");
            pecsExercisesList.add("Hammer Incline Bench Press");
            pecsExercisesList.add("Hammer Sitting Bench Press");
            pecsExercisesList.add("Dumb-bells Flat Bench Press");
            pecsExercisesList.add("Dumb-bells Incline Bench Press");
            pecsExercisesList.add("Dumb-bells Decline Bench Press");
            pecsExercisesList.add("Dumbbell Flys");
            pecsExercisesList.add("Dumbbell Flys Incline");
            pecsExercisesList.add("Hammer Machine Flys");
            pecsExercisesList.add("Chest Squeeze Pushup");
            pecsExercisesList.add("Cable Fly");
            pecsExercisesList.add("Wide-grip Push Ups");
            pecsExercisesList.add("Dumbbell Around The World");
            pecsExercisesList.add("Suspended Pushup");
            pecsExercisesList.add("Bars Dips");

            return pecsExercisesList;

        } else if (workoutType.equalsIgnoreCase("TRICEPS")) {

            tricepsExercisesList.add("Close-grip Bench Press");
            tricepsExercisesList.add("Standing Barbell Triceps Extensions");
            tricepsExercisesList.add("1-Dumbbell Triceps Overhead Extensions");
            tricepsExercisesList.add("Pulley Push-Downs");
            tricepsExercisesList.add("Lying Barbell Triceps Extensions");
            tricepsExercisesList.add("Dumbbell Squeeze Press");
            tricepsExercisesList.add("Rope Tricep Pushdown");
            tricepsExercisesList.add("Triceps Dips");

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
            deltsExercisesList.add("Smith Machine Press");
            deltsExercisesList.add("Kettlebell Pull to Chin");
            deltsExercisesList.add("Barbell Pull to Chin");
            deltsExercisesList.add("Dumbbells Press Sitting");
            deltsExercisesList.add("Dumbbells Press Standing");
            deltsExercisesList.add("Kettlebell Press");
            deltsExercisesList.add("Dumbbells Raises for Middle Delts");
            deltsExercisesList.add("Dumbbells Raises for Back Delts");
            deltsExercisesList.add("Dumbbells Raises for Front Delts");

            return deltsExercisesList;
        }

        return defList;

    }

    public static void addExerciseToList(String exerciseName, String workoutType) {

        List<String> defList = new ArrayList<>();
        List<String> bicepsExercisesList = new ArrayList<>();
        List<String> backExercisesList = new ArrayList<>();
        List<String> pecsExercisesList = new ArrayList<>();
        List<String> tricepsExercisesList = new ArrayList<>();
        List<String> deltsExercisesList = new ArrayList<>();
        List<String> absExercisesList = new ArrayList<>();
        List<String> trapsExercisesList = new ArrayList<>();
        List<String> forearmsExercisesList = new ArrayList<>();
        List<String> quadsExercisesList = new ArrayList<>();
        List<String> calvesExercisesList = new ArrayList<>();

        if (workoutType.equalsIgnoreCase("PECS")) {
            pecsExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("TRICEPS")) {
            tricepsExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("BICEPS")) {
            bicepsExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("FOREARMS")) {
            forearmsExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("DELTS")) {
            deltsExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("BACK")) {
            backExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("QUADS")) {
            quadsExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("CALVES")) {
            calvesExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("ABS")) {
            absExercisesList.add(exerciseName);
        } else if (workoutType.equalsIgnoreCase("TRAPS")) {
            trapsExercisesList.add(exerciseName);
        }

    }

}
