package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
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

    @GetMapping("/exercise/{id}/view")
    public String getExercises(@PathVariable long id, Model model) {

        Exercise exercise = exerciseRepository.findById(id).get();

        model.addAttribute("exercise", exercise);
        model.addAttribute("workout", exercise.getWorkout());

        return "exercises/exercise";
    }
}
