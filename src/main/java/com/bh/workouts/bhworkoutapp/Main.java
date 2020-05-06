package com.bh.workouts.bhworkoutapp;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Month currentMonth = LocalDate.now().getMonth();

        Calendar calendar = Calendar.getInstance();

        calendar.get(Calendar.WEEK_OF_MONTH);

        System.out.println(currentMonth.name());

    }
}
    