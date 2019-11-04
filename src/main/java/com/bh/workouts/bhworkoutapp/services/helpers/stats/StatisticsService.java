package com.bh.workouts.bhworkoutapp.services.helpers.stats;

import java.util.List;
import java.util.Map;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;

public interface StatisticsService {

    List<Workout> getWorkoutCountsByDatesRange(String dateFrom, String dateTo);
    Map<String, Integer> getWorkoutsForYear(int year, User user);
    public int getWorkoutsNumberByType(String month, String workoutType, User user);

}