package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.exercise.ExerciseNameService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;

public class UserRegistrationControllerTest {

    @Mock
    UserService userService;

    @Mock
    ExerciseNameService exerciseNameService;

    @Mock
    BindingResult bindingResult;

    @Mock
    Model model;

    User user;

    @InjectMocks
    UserRegistrationController userRegistrationController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new User();
        model.addAttribute("user", user);
    }

    @Test
    public void registration() {

        assertEquals("register-user", userRegistrationController.registration(model));
    }

    @Test
    public void createNewUser() {

        assertEquals("login", userRegistrationController.createNewUser(user, bindingResult, model));
        assertFalse(model.containsAttribute("user"));

    }
}