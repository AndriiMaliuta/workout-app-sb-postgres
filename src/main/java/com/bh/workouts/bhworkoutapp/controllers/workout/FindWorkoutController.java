package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FindWorkoutController {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public FindWorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/workout/find")
    public String getFindForm(Model model) {

        model.addAttribute("workout", new Workout());

        return "workouts/find-workout";
    }

    @PostMapping("/workout/find")
    public String findWorkoutbyName(@ModelAttribute Workout workout, Model model) {

        List<Workout> foundWorkouts = workoutRepository.findWorkoutByWorkoutDate(workout.getWorkoutDate());

        model.addAttribute("foundWorkouts", foundWorkouts);

        return "workouts/found-workouts";
    }
}
