package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.controllers.workout.CreateWorkoutController;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(CreateWorkoutController.class);

    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public HomeController(AuthInitiatorService authInitiatorService) {
        this.authInitiatorService = authInitiatorService;
    }

    @RequestMapping("/home")
    public String getHome(Model model) {

        model.addAttribute("userName", authInitiatorService.getUserFromAuth().getFirstName());

        logger.info("============= Home page initiated by "+ authInitiatorService.getUserFromAuth().getFirstName());

//        logger.info("======== Testing for May 2019 == " + statisticsService.getWorkoutsForYear(2019, authInitiatorService.getUserFromAuth()));

//        model.addAttribute("workoutsMap", statisticsService.getWorkoutsForYear(2019, authInitiatorService.getUserFromAuth()));

        return "home";
    }
}
