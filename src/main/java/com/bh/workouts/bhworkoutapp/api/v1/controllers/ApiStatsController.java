package com.bh.workouts.bhworkoutapp.api.v1.controllers;

import com.bh.workouts.bhworkoutapp.api.v1.models.MonthCountModel;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiStatsController.REST_API_URL)
public class ApiStatsController {

    private final WorkoutService workoutService;
    private final AuthInitiatorService authInitiatorService;

    public ApiStatsController(WorkoutService workoutService, AuthInitiatorService authInitiatorService) {
        this.workoutService = workoutService;
        this.authInitiatorService = authInitiatorService;
    }

    static final String REST_API_URL = "/rest/api/v1/stats/workouts";

    @GetMapping("/{year}")
    public MonthCountModel getSizeByMonth(@PathVariable int year) {

        MonthCountModel monthCountModel = new MonthCountModel();

        monthCountModel.setJanuary(workoutService.getWorkoutsByYearMonth(
                workoutService.userWorkouts(workoutService.findAllWorkouts(), authInitiatorService.getUserFromAuth()),year, "January").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "February").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "March").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "April").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "May").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "June").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "July").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "August").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "September").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "October").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "November").size());
        monthCountModel.setFebruary(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "December").size());

        return monthCountModel;
    }
}
