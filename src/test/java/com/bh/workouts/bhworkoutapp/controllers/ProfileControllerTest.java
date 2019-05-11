package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import static org.junit.Assert.*;

public class ProfileControllerTest {

    @Mock
    UserService userService;

    @Mock
    Model model;

    @Mock
    Authentication authentication;

    ProfileController profileController;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        profileController = new ProfileController(userService);
    }

    @Test
    public void getProfilePage() {

        String returnString = profileController.getProfilePage(model);

        assertEquals("profile/profile", returnString);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        String captured = argumentCaptor.capture();
        System.out.printf(captured);
    }
}