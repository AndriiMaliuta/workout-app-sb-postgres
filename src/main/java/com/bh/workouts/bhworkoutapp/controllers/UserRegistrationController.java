package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class UserRegistrationController {

    private Logger logger = Logger.getLogger(UserRegistrationController.class.getName());

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model){

        model.addAttribute("user", new User());

        return "register-user";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {

        User userExists = userService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }

        if (bindingResult.hasErrors()) {

            return "register-user";

        } else {

            userService.saveUser(user);

            model.addAttribute("user", new User());
            model.addAttribute("successMessage", "User has been registered successfully");

            return "login";

        }
    }
}
