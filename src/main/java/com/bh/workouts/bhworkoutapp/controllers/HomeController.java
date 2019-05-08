package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.controllers.workout.CreateWorkoutController;
import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.services.exercise.ExerciseNameService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(CreateWorkoutController.class);

    private final UserService userService;
    private final ExerciseNameService exerciseNameService;
    private final ExerciseNameRepository exerciseNameRepository;

    @Autowired
    public HomeController(UserService userService,
                          ExerciseNameService exerciseNameService,
                          ExerciseNameRepository exerciseNameRepository) {
        this.userService = userService;
        this.exerciseNameService = exerciseNameService;
        this.exerciseNameRepository = exerciseNameRepository;
    }

    @RequestMapping("/home")
    public String getHome(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("userName", userService.findUserByLogin(authentication.getName()).getFirstName());

        logger.info("**** User Name is " + authentication.getName());

        User userByLogin = userService.findUserByLogin(authentication.getName());

        int counter = 1;

        for (ExerciseName exerciseName : exerciseNameRepository.findAll()) {
            exerciseName.setUser(userByLogin);
            logger.info(counter + " success");
            counter++;
        }

        return "home";
    }
}
