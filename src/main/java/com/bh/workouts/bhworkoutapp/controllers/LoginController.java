package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.RoleEnum;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.WorkoutType;
import com.bh.workouts.bhworkoutapp.services.ExerciseNameService;
import com.bh.workouts.bhworkoutapp.services.InitExercisesService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class LoginController {

    private final UserService userService;
    private final ExerciseNameService exerciseNameService;

    public LoginController(UserService userService, ExerciseNameService exerciseNameService) {
        this.userService = userService;
        this.exerciseNameService = exerciseNameService;
    }

    private Logger logger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping({"/", "/login"})
    public String login() {

        User anma = new User();

        anma.setId(1L);
        anma.setActive(1);
        anma.setPassword("mypass");
        anma.setRoles(RoleEnum.ADMIN);
        anma.setLogin("anma");
        anma.setFirstName("Andrii");
        anma.setLastName("Maliuta");
        anma.setEmail("m@m");

        userService.saveUser(anma);


        logger.info("=======================");
        logger.info("Getting Login page");

        return "login";
    }


}
