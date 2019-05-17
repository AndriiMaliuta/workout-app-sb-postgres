package com.bh.workouts.bhworkoutapp.services.dates;

import com.bh.workouts.bhworkoutapp.models.CurrentWorkoutDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrentWorkoutDaysByWeekService {

    public static List<CurrentWorkoutDay> getCurrentWorkoutDaysByWeek(Map<Integer, CurrentWorkoutDay> workoutDays, int week) {

        List<CurrentWorkoutDay> currentWorkoutDaysByWeek = new ArrayList<>();

        for (CurrentWorkoutDay currentWorkoutDay : workoutDays.values()) {

            if (currentWorkoutDay.getWeek() == week) {

                currentWorkoutDaysByWeek.add(currentWorkoutDay);
            }
        }

        return currentWorkoutDaysByWeek;
    }
}
