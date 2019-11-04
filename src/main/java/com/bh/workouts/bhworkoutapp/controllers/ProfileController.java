package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    private final UserServiceImpl userService;

    @Autowired
    public ProfileController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/profile")
    public String getProfilePage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(auth.getName());

        model.addAttribute("user", userByLogin);

        return "profile/profile";
    }


}
