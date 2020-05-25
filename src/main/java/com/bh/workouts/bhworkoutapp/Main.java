package com.bh.workouts.bhworkoutapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws ParseException {

        //YearWeek.from(                         // Represents week of standard ISO 8601 defined week-based-year (as opposed to a calendar year).
        //        LocalDate.parse( "2017-01-23" )    // Represents a date-only value, without time-of-day and without time zone.
       // )                                      // Returns a `YearWeek` object.
         //       .getWeek()

//        date = df.parse(w.getWorkoutDate());
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);

//        Month currentMonth = LocalDate.of(2020, 5, 1).getMonth();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        calendar.setTime(format.parse("31/05/2020"));

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int week = calendar.get(Calendar.WEEK_OF_MONTH);

        System.out.println(year);
        System.out.println(month);
        System.out.println(week);
        System.out.println(dayOfYear);

    }
}
    