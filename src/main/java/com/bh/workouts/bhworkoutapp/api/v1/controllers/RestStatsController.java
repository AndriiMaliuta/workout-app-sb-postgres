package com.bh.workouts.bhworkoutapp.api.v1.controllers;

import com.bh.workouts.bhworkoutapp.api.v1.models.MonthCountModel;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestStatsController.REST_API_URL)
@CrossOrigin(origins = {"https://anma-workouts.netlify.app/workouts", "http://localhost:3000"})
public class RestStatsController {

    private final WorkoutService workoutService;
    private final AuthInitiatorService authInitiatorService;

    public RestStatsController(WorkoutService workoutService, AuthInitiatorService authInitiatorService) {
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
        monthCountModel.setMarch(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "March").size());
        monthCountModel.setApril(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "April").size());
        monthCountModel.setMay(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "May").size());
        monthCountModel.setJune(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "June").size());
        monthCountModel.setJuly(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "July").size());
        monthCountModel.setAugust(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "August").size());
        monthCountModel.setSeptember(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "September").size());
        monthCountModel.setOctober(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "October").size());
        monthCountModel.setNovember(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "November").size());
        monthCountModel.setDecember(workoutService.getWorkoutsByYearMonth(workoutService.findAllWorkouts(), year, "December").size());

        return monthCountModel;
    }
}
