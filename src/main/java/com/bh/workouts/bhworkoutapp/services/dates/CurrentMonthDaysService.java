package com.bh.workouts.bhworkoutapp.services.dates;

import com.bh.workouts.bhworkoutapp.models.CurrentWorkoutDay;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class CurrentMonthDaysService {

    public static Map<Integer, CurrentWorkoutDay> getMonthDays(YearMonth yearMonth) {

        Map<Integer, CurrentWorkoutDay> map = new TreeMap<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        LocalDate firstDayOfMonth = yearMonth.atDay( 1 );
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();

        LocalDate localDate = firstDayOfMonth;

        while(!localDate.isAfter(lastDayOfMonth)) {

            int day = localDate.getDayOfMonth();

            CurrentWorkoutDay currentWorkoutDay = new CurrentWorkoutDay();

            LocalDate localDateForDay = localDate.withDayOfMonth(day);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault())
                    .toInstant()));

            Date localDateDate = Date.from(localDateForDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

            String formattedLocalDate = simpleDateFormat.format(localDateDate);

            String dayName = localDate.withDayOfMonth(day).getDayOfWeek().name();

            currentWorkoutDay.setDayName(dayName);
            currentWorkoutDay.setDayNumber(day);
            currentWorkoutDay.setTodayWeekDate(formattedLocalDate);
            currentWorkoutDay.setMonthName(localDate.getMonth().name());
            currentWorkoutDay.setYear(localDate.getYear());
            currentWorkoutDay.setWeek(calendar.get(Calendar.WEEK_OF_MONTH));

            map.put(day, currentWorkoutDay);

            localDate = localDate.plusDays( 1 );
        }

        return map;

    }
}
