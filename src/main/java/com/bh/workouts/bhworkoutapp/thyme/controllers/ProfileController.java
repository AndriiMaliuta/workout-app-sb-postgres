package com.bh.workouts.bhworkoutapp.thyme.controllers;

import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    private Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public ProfileController(AuthInitiatorService authInitiatorService) {
        this.authInitiatorService = authInitiatorService;
    }

    @RequestMapping("/profile")
    public String getProfilePage(Model model) {

        model.addAttribute("user", authInitiatorService.getUserFromAuth());

        logger.info("=========== Opening Profile page for: " + authInitiatorService.getUserFromAuth().getLogin());

        return "profile/profile";
    }


}
