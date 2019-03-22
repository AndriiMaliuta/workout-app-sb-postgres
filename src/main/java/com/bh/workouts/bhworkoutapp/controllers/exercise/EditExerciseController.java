package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;

    @Autowired
    public EditExerciseController(ExerciseRepository exerciseRepository,
                                  WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/exercise/{exercise-id}/edit")
    public String getForm(@PathVariable long exerciseId,  Model model) {

        model.addAttribute("exercise", exerciseRepository.findById(exerciseId));

        return "edit-exercise";
    }

    @PostMapping("/exercise/{exercise-id}/edit")
    public String editExercise(@PathVariable long exerciseId, @ModelAttribute Exercise exercise) {

        exerciseRepository.save(exercise);

        return "/exercise/" + exercise.getId();
    }


}
