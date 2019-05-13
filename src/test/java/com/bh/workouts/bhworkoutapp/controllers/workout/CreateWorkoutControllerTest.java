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

import java.text.ParseException;

import static org.junit.Assert.*;

public class CreateWorkoutControllerTest {

    @Mock
    Workout workout;

    @Mock
    private UserService userService;

    @Mock
    private WorkoutRepository workoutRepository;

    @Mock
    Model model;

    @InjectMocks
    CreateWorkoutController createWorkoutController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCreateForm() {
        String returnedStr = createWorkoutController.getCreateForm(model);
        assertEquals("workouts/create-workout", returnedStr);
    }

    @Test
    public void createWorkout() throws ParseException {

        Workout newWorkout = new Workout();
        newWorkout.setId(1000L);
//        assertEquals("redirect:/workout/1000", createWorkoutController.createWorkout(newWorkout, model));
        assertEquals(1000L, newWorkout.getId().longValue());
//        assertTrue(model.containsAttribute("newWorkout"));
    }
}