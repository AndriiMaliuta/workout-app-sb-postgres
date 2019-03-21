package com.bh.workouts.bhworkoutapp.services;

import java.util.Calendar;

public class DayOfWeekService {

    public static String dayOfWeek() {

        String dayOfWeek = "";

        Calendar calendar = Calendar.getInstance();

        int dayNumber = calendar.get(Calendar.DAY_OF_WEEK);

        if (dayNumber == 1) {
            dayOfWeek = "Sunday";
        } else if (dayNumber == 2) {
            dayOfWeek = "Monday";
        } else if (dayNumber == 3) {
            dayOfWeek = "Tuesday";
        } else if (dayNumber == 4) {
            dayOfWeek = "Wednesday";
        } else if (dayNumber == 5) {
            dayOfWeek = "Thursday";
        } else if (dayNumber == 6) {
            dayOfWeek = "Friday";
        } else if (dayNumber == 7) {
            dayOfWeek = "Saturday";
        }

        return dayOfWeek;
    }


}
