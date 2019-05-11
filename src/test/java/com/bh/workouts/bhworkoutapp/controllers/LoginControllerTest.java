package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.exercise.ExerciseNameService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class LoginControllerTest {

    @Mock
    UserService userService;

    @Mock
    ExerciseNameService exerciseNameService;

    LoginController loginController;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        loginController = new LoginController(userService, exerciseNameService);
    }

    @Test
    public void testMockMVC() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void login() {

        String retLogin = loginController.login();

        assertEquals("login", retLogin);

    }
}