package com.bh.workouts.bhworkoutapp.api.v1.controllers;

import com.bh.workouts.bhworkoutapp.api.v1.models.MonthCountModel;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiStatsController.REST_API_URL)
public class ApiStatsController {

    private final WorkoutService workoutService;

    public ApiStatsController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    static final String REST_API_URL = "/rest/api/v1/stats/workouts/{year}/{month}/count";

    @GetMapping
    public MonthCountModel getSizeByMonth(@PathVariable int year, @PathVariable String month) {

        MonthCountModel monthCountModel = new MonthCountModel();

        monthCountModel.setJanuary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, month).size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, month).size());

        return monthCountModel;
    }
}
