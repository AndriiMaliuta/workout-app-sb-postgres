package com.bh.workouts.bhworkoutapp.services.stats;

import java.time.LocalDate;

public class MonthWorkoutsStatsService {

    private static int getWorkoutsNumberByType(String workoutType) {

        int numberOfWorkouts = 0;

        LocalDate localDate = LocalDate.now();
        localDate.getMonthValue();



        return numberOfWorkouts;
    }
}
