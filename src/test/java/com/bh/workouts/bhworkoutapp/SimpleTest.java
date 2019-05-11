package com.bh.workouts.bhworkoutapp;

import com.bh.workouts.bhworkoutapp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SimpleTest {

    LocalDate localDate;

    @InjectMocks
    UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {

        localDate = LocalDate.now();

        assertEquals("2019-05-11", localDate.toString());

        assertEquals("MAY", localDate.getMonth().name());

//        verify(userService.findUserByLogin("anma"), times(1));

        assertNull(userService.findUserByLogin("anma"));
    }
}
