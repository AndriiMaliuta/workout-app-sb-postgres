package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.UserRepository;
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
public class EditProfileController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public EditProfileController(UserService userService,
                                 UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/profile/edit")
    public String editProfilePageForm(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User userByLogin = userService.findUserByLogin(auth.getName());

        model.addAttribute("user", userByLogin);

        return "profile/edit-profile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute User user) {

        user.setLogin(userRepository.findById(user.getId()).get().getLogin());
        user.setEmail(userRepository.findById(user.getId()).get().getEmail());
        user.setActive(userRepository.findById(user.getId()).get().getActive());
        user.setRoles(userRepository.findById(user.getId()).get().getRoles());

        userRepository.save(user);

        return "redirect:/profile";
    }


}
