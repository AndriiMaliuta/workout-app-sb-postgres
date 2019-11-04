package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.UserRepository;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditProfileController {

    Logger logger = LoggerFactory.getLogger(EditProfileController.class);

    private final UserRepository userRepository;
    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public EditProfileController(UserRepository userRepository,
                                 AuthInitiatorService authInitiatorService) {
        this.userRepository = userRepository;
        this.authInitiatorService = authInitiatorService;
    }

    @GetMapping("/profile/edit")
    public String editProfilePageForm(Model model) {

        model.addAttribute("user", authInitiatorService.getUserFromAuth());

        return "profile/edit-profile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute User user) {

        user.setLogin(userRepository.findById(user.getId()).get().getLogin());
        user.setEmail(userRepository.findById(user.getId()).get().getEmail());
        user.setActive(userRepository.findById(user.getId()).get().getActive());
        user.setRoles(userRepository.findById(user.getId()).get().getRoles());

        userRepository.save(user);

        logger.info("============ Profile edited successfully for: " + user.getLogin());

        return "redirect:/profile";
    }


}
