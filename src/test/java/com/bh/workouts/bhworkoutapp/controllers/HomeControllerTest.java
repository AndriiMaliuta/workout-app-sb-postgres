package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.exercise.ExerciseNameService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HomeControllerTest {

    @Mock
    UserService userService;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    ExerciseNameRepository exerciseNameRepository;

    @Mock
    ExerciseNameService exerciseNameService;

    @Mock
    Model model;

    HomeController homeController;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        homeController = new HomeController(userService, exerciseNameService, exerciseNameRepository);

    }

    @Test
    public void getHome() {

        String viewName = homeController.getHome(model);

        assertEquals("home", viewName);

        verify(model, times(1)).addAttribute(eq("userName"), anyString());
        verify(exerciseNameService, times(1)).getOwnExerciseNames();
    }
}