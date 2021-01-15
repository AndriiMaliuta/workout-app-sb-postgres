package com.bh.workouts.bhworkoutapp.api.v1.controllers;

import com.bh.workouts.bhworkoutapp.api.v1.models.UserRest;
import com.bh.workouts.bhworkoutapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://anma-workouts.netlify.app/workouts", "http://localhost:3000"})
public class RestProfileController {

    private final UserRepository userRepository;

    public RestProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/rest/api/v1/users/{login}")
    public UserRest getUserInfo(@PathVariable String login) {

        return new ModelMapper().map(userRepository.findByLogin(login).get(), UserRest.class);
    }


}
