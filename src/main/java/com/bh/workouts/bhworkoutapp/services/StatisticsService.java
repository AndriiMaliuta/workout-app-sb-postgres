package com.bh.workouts.bhworkoutapp.services;

import java.util.List;

import com.bh.workouts.bhworkoutapp.models.Workout;

public interface StatisticsService {

    List<Workout> getMonthWorkouts(String dateFrom, String dateTo);

}