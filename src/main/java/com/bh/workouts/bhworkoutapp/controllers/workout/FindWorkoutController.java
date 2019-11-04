package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.services.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FindWorkoutController {

    private final WorkoutService workoutService;
    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public FindWorkoutController(WorkoutService workoutService, AuthInitiatorService authInitiatorService) {
        this.workoutService = workoutService;
        this.authInitiatorService = authInitiatorService;
    }

    @GetMapping("/workout/find")
    public String getFindForm(Model model) {

        model.addAttribute("workout", new Workout());

        return "workouts/find-workout";
    }

    @PostMapping("/workout/find")
    public String findWorkoutByName(@ModelAttribute Workout workout, Model model) {

        String date = workout.getWorkoutDate();

        List<Workout> workouts = workoutService.findWorkoutByWorkoutDate(date);
        List<Workout> userWorkouts = workoutService.userWorkouts(workouts, authInitiatorService.getUserFromAuth());

        model.addAttribute("foundUserWorkouts", userWorkouts);

        return "workouts/found-workouts";
    }
}
