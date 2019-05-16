package com.bh.workouts.bhworkoutapp;

import com.bh.workouts.bhworkoutapp.services.dates.WorkoutDateTrimToMonthService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Month currentMonth = LocalDate.now().getMonth();

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));

        System.out.println(LocalDate.now().getDayOfWeek().name());

//        WeekFields week = WeekFields.of(firstDayOfWeek, minDays);

        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        System.out.println(weekFields.weekOfMonth().getDisplayName(Locale.getDefault()));

        TemporalField temporalField = weekFields.weekOfMonth();

        System.out.println(temporalField);

    }
}
