package com.bh.workouts.bhworkoutapp.api.v1.controllers;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiWorkoutController.BASE_URL)
public class ApiWorkoutController {

    static final String BASE_URL = "/api/v1/workouts/";

    private final WorkoutRepository workoutRepository;

    @Autowired
    public ApiWorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Workout> getWorkoutsForApi() {

        return workoutRepository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Workout getWorkoutByIdApi(@PathVariable long id) {

        return workoutRepository.findById(id).get();
    }
}
