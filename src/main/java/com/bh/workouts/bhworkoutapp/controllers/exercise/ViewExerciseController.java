package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ViewExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/workout/{id}/exercises/view")
    public String getExercises(@PathVariable long id, Model model) {

        model.addAttribute("exercises", exerciseRepository.findAll());

        return "exercises/exercises";
    }

    @GetMapping("/exercise/{id}")
    public String getWorkout(@PathVariable long id, Model model) {

        model.addAttribute("exercise", exerciseRepository.findById(id).get());

        return "exercises/exercise";
    }
}
