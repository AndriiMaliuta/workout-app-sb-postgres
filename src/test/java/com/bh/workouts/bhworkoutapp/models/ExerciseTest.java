package com.bh.workouts.bhworkoutapp.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseTest {

    Exercise exercise;

    @Before
    public void setUp() {
        exercise = new Exercise();
    }

    @Test
    public void getId() {

        Long idValue = 4L;

        exercise.setId(idValue);

        assertEquals(idValue.longValue(), exercise.getId());
    }

    @Test
    public void getTitle() {
    }

    @Test
    public void getWorkout() {
    }

    @Test
    public void getSets() {
    }

    @Test
    public void getOverallWeight() {
    }
}