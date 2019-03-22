package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.ExerciseSelectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;

    @Autowired
    public CreateExerciseController(ExerciseRepository exerciseRepository,
                                    WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/workout/{id}/exercise/new")
    public String getCreateForm(@PathVariable long id, Model model) {

        model.addAttribute("exercise", new Exercise());

        Workout workout = workoutRepository.findById(id).get();

        model.addAttribute("workout", workout);

        model.addAttribute("exercisesList", ExerciseSelectorService.getExercisesList(workout.getWorkoutType()));

        return "exercises/create-exercise";
    }

    @PostMapping("/workout/{id}/exercise/new")
    public String createExercise(@ModelAttribute Exercise exercise, @PathVariable long id, Model model) {

        Exercise newExercise = new Exercise();

        newExercise.setTitle(exercise.getTitle());
        newExercise.setWorkout(workoutRepository.findById(id).get());

        exerciseRepository.save(newExercise);

        model.addAttribute("newExercise", newExercise);

        return "redirect:/exercise/" + newExercise.getId();
    }
}
