package com.bh.workouts.bhworkoutapp.services;

import com.bh.workouts.bhworkoutapp.models.CurrentWorkoutDay;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.*;

public class CurrentMonthDaysService {

    public static Map<Integer, CurrentWorkoutDay> getMonthDays() {

        Map<Integer, CurrentWorkoutDay> map = new TreeMap<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        YearMonth yearMonth = YearMonth.now();

        LocalDate firstDayOfMonth = yearMonth.atDay( 1 );
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();

        LocalDate localDate = firstDayOfMonth;

        while(!localDate.isAfter(lastDayOfMonth)) {

            int day = localDate.getDayOfMonth();

            CurrentWorkoutDay currentWorkoutDay = new CurrentWorkoutDay();

            LocalDate localDateForDay = localDate.withDayOfMonth(day);

            Date localDateDate = Date.from(localDateForDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

            String formattedLocalDate = simpleDateFormat.format(localDateDate);

            String dayName = localDate.withDayOfMonth(day).getDayOfWeek().name();

            currentWorkoutDay.setDayName(dayName);
            currentWorkoutDay.setDaynumber(day);
            currentWorkoutDay.setTodayWeekDate(formattedLocalDate);
            currentWorkoutDay.setMonthName(localDate.getMonth().name());
            currentWorkoutDay.setYear(localDate.getYear());

            map.put(day, currentWorkoutDay);

            localDate = localDate.plusDays( 1 );
        }

        return map;

    }
}
