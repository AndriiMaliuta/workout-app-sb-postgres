package com.bh.workouts.bhworkoutapp.services.helpers.stats;

import com.bh.workouts.bhworkoutapp.models.User;

public interface MonthWorkoutsStatsService {

    public int getWorkoutsNumberByType(String month, String workoutType, User user);

}