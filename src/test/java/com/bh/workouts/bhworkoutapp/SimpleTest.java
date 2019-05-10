package com.bh.workouts.bhworkoutapp;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class SimpleTest {

    @Test
    public void test() {

        LocalDate localDate = LocalDate.now();

        assertEquals("2019-05-10", localDate.toString());

        assertEquals("MAY", localDate.getMonth().name());

    }
}
