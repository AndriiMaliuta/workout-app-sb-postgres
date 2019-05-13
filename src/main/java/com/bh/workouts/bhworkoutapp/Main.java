package com.bh.workouts.bhworkoutapp;

import com.bh.workouts.bhworkoutapp.services.dates.WorkoutDateTrimToMonthService;

public class Main {

    public static void main(String[] args) {

        System.out.println(WorkoutDateTrimToMonthService.getTrimmedMonthFromDate("11/10/2019"));
    }
}
