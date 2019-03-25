package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public DeleteExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/workout/{workoutId}/exercise/{exerciseId}/delete")
    public String deleteExercise(@PathVariable long workoutId, @PathVariable long exerciseId) {

        exerciseRepository.deleteById(exerciseId);

        return "redirect:/workout/" + workoutId;
    }
}
