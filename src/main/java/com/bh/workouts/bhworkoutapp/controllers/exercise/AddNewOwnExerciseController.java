package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddNewOwnExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseNameRepository exerciseNameRepository;
    private final UserService userService;

    @Autowired
    public AddNewOwnExerciseController(ExerciseRepository exerciseRepository,
                                       ExerciseNameRepository exerciseNameRepository,
                                       UserService userService) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseNameRepository = exerciseNameRepository;
        this.userService = userService;
    }

    @RequestMapping("/exercises/own")
    public String getOwnExercises(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        model.addAttribute("ownExercisesList", exerciseNameRepository.findExerciseNameByUser(userByLogin));

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

        exerciseName.setUser(userByLogin);

        exerciseNameRepository.save(exerciseName);

        return "exercises/add-own";
    }
}
