package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.services.exercise.ExerciseNameService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OwnExerciseController {

    private final UserService userService;
    private final ExerciseNameService exerciseNameService;
    private final ExerciseNameRepository exerciseNameRepository;

    @Autowired
    public OwnExerciseController(UserService userService,
                                 ExerciseNameService exerciseNameService,
                                 ExerciseNameRepository exerciseNameRepository) {
        this.userService = userService;
        this.exerciseNameService = exerciseNameService;
        this.exerciseNameRepository = exerciseNameRepository;
    }

    @GetMapping("/exercises/own")
    public String getOwnExercises(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User userByLogin = userService.findUserByLogin(authentication.getName());

        model.addAttribute("ownExercisesList", exerciseNameService.getUserExerciseNames());

        return "exercises/own-exercises";
    }

    @GetMapping("/exercise/own/add")
    public String getForm(Model model) {

        model.addAttribute("exerciseName", new ExerciseName());

        return "exercises/add-own";

    }

    @PostMapping("/exercise/own/add")
    public String addOwnExercise(@ModelAttribute ExerciseName exerciseName) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User userByLogin = userService.findUserByLogin(authentication.getName());

        ExerciseName newExerciseName = new ExerciseName();

        newExerciseName.setName(exerciseName.getName());
        newExerciseName.setUser(userByLogin);
        newExerciseName.setCategory(exerciseName.getCategory());

        exerciseNameRepository.save(exerciseName);

        return "redirect:/exercises/own";
    }
}
