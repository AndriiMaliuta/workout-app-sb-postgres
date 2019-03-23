package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.ExerciseSelectorService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CreateExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseNameRepository exerciseNameRepository;
    private final UserService userService;

    @Autowired
    public CreateExerciseController(ExerciseRepository exerciseRepository,
                                    WorkoutRepository workoutRepository,
                                    ExerciseNameRepository exerciseNameRepository,
                                    UserService userService) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseNameRepository = exerciseNameRepository;
        this.userService = userService;
    }

    @GetMapping("/workout/{id}/exercise/new")
    public String getCreateForm(@PathVariable long id, Model model) {

        model.addAttribute("exercise", new Exercise());

        Workout workout = workoutRepository.findById(id).get();

        model.addAttribute("workout", workout);

        List<ExerciseName> exercisesList = exerciseNameRepository.findAll();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("exercisesList",
                ExerciseSelectorService.getExercisesList(exercisesList, workout.getWorkoutType(), userService.findUserByLogin(authentication.getName())));

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
