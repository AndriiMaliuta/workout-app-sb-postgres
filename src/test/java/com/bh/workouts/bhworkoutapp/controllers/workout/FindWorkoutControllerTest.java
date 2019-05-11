package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;

public class FindWorkoutControllerTest {

    @Mock
    private WorkoutRepository workoutRepository;

    @InjectMocks
    FindWorkoutController findWorkoutController;

    @Mock
    private UserService userService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void getFindForm() {

        String retStr = findWorkoutController.getFindForm(model);

        assertEquals("workouts/find-workout", retStr);

    }

    @Test
    public void findWorkoutbyName() {

        assertEquals(0, workoutRepository.findAll().size());
    }
}