package com.bh.workouts.bhworkoutapp.services.dates;

import com.bh.workouts.bhworkoutapp.models.CurrentWorkoutDay;

import java.text.SimpleDateFormat;
import java.util.*;

public class CurrentWeekDaysService {

    public static Map<String, Object> getCurrentWeekDaysAnsWorkouts() {

        String convertedSundayDate;
        String convertedMondayDate;
        String convertedTuesdayDate;
        String convertedWednesdayDate;
        String convertedThursdayDate;
        String convertedFridayDate;
        String convertedSaturdayDate;

        Map<String, Object> map = new HashMap<>();

        CurrentWorkoutDay currentWorkoutDay = new CurrentWorkoutDay();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Calendar calendar = Calendar.getInstance();

        Date currentDayDate = new Date();

        calendar.setTime(currentDayDate);

        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {

            Date sundayDate = new Date();
            convertedSundayDate = dateFormat.format(sundayDate);
            currentWorkoutDay.setTodayWeekDate(convertedSundayDate);
            map.put("convertedSundayDate", convertedSundayDate);

            calendar.add(Calendar.DATE, +1);
            Date mondayDate = calendar.getTime();
            convertedMondayDate = dateFormat.format(mondayDate);
            map.put("convertedMondayDate", convertedMondayDate);

            calendar.add(Calendar.DATE, +1);
            Date tuesdayDate = calendar.getTime();
            convertedTuesdayDate = dateFormat.format(tuesdayDate);
            map.put("convertedTuesdayDate", convertedTuesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date wednesdayDate = calendar.getTime();
            convertedWednesdayDate = dateFormat.format(wednesdayDate);
            map.put("convertedWednesdayDate", convertedWednesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date thursdayDate = calendar.getTime();
            convertedThursdayDate = dateFormat.format(thursdayDate);
            map.put("convertedThursdayDate", convertedThursdayDate);

            calendar.add(Calendar.DATE, +1);
            Date fridayDate = calendar.getTime();
            convertedFridayDate = dateFormat.format(fridayDate);
            map.put("convertedFridayDate", convertedFridayDate);

            calendar.add(Calendar.DATE, +1);
            Date saturdayDate = calendar.getTime();
            convertedSaturdayDate = dateFormat.format(saturdayDate);
            map.put("convertedSaturdayDate", convertedSaturdayDate);

        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 2) {

            Date mondayDate = new Date();
            convertedMondayDate = dateFormat.format(mondayDate);
            map.put("convertedMondayDate", convertedMondayDate);

            calendar.add(Calendar.DATE, -1);
            Date sundayDate = calendar.getTime();
            convertedSundayDate = dateFormat.format(sundayDate);
            map.put("convertedSundayDate", convertedSundayDate);

            calendar.add(Calendar.DATE, +2);
            Date tuesdayDate = calendar.getTime();
            convertedTuesdayDate = dateFormat.format(tuesdayDate);
            map.put("convertedTuesdayDate", convertedTuesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date wednesdayDate = calendar.getTime();
            convertedWednesdayDate = dateFormat.format(wednesdayDate);
            map.put("convertedWednesdayDate", convertedWednesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date thursdayDate = calendar.getTime();
            convertedThursdayDate = dateFormat.format(thursdayDate);
            map.put("convertedThursdayDate", convertedThursdayDate);

            calendar.add(Calendar.DATE, +1);
            Date fridayDate = calendar.getTime();
            convertedFridayDate = dateFormat.format(fridayDate);
            map.put("convertedFridayDate", convertedFridayDate);

            calendar.add(Calendar.DATE, +1);
            Date saturdayDate = calendar.getTime();
            convertedSaturdayDate = dateFormat.format(saturdayDate);
            map.put("convertedSaturdayDate", convertedSaturdayDate);

        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 3) {

            Date tuesdayDate = new Date();
            convertedTuesdayDate = dateFormat.format(tuesdayDate);
            map.put("convertedTuesdayDate", convertedTuesdayDate);

            calendar.add(Calendar.DATE, -2);
            Date sundayDate = calendar.getTime();
            convertedSundayDate = dateFormat.format(sundayDate);
            map.put("convertedSundayDate", convertedSundayDate);

            calendar.add(Calendar.DATE, +1);
            Date mondayDate = calendar.getTime();
            convertedMondayDate = dateFormat.format(mondayDate);
            map.put("convertedMondayDate", convertedMondayDate);

            calendar.add(Calendar.DATE, +2);
            Date wednesdayDate = calendar.getTime();
            convertedWednesdayDate = dateFormat.format(wednesdayDate);
            map.put("convertedWednesdayDate", convertedWednesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date thursdayDate = calendar.getTime();
            convertedThursdayDate = dateFormat.format(thursdayDate);
            map.put("convertedThursdayDate", convertedThursdayDate);

            calendar.add(Calendar.DATE, +1);
            Date fridayDate = calendar.getTime();
            convertedFridayDate = dateFormat.format(fridayDate);
            map.put("convertedFridayDate", convertedFridayDate);

            calendar.add(Calendar.DATE, +1);
            Date saturdayDate = calendar.getTime();
            convertedSaturdayDate = dateFormat.format(saturdayDate);
            map.put("convertedSaturdayDate", convertedSaturdayDate);

        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 4) {

            Date wednesdayDate = new Date();
            convertedWednesdayDate = dateFormat.format(wednesdayDate);
            map.put("convertedWednesdayDate", convertedWednesdayDate);

            calendar.add(Calendar.DATE, -3);
            Date sundayDate = calendar.getTime();
            convertedSundayDate = dateFormat.format(sundayDate);
            map.put("convertedSundayDate", convertedSundayDate);

            calendar.add(Calendar.DATE, +1);
            Date mondayDate = calendar.getTime();
            convertedMondayDate = dateFormat.format(mondayDate);
            map.put("convertedMondayDate", convertedMondayDate);

            calendar.add(Calendar.DATE, +1);
            Date tuesdayDate = calendar.getTime();
            convertedTuesdayDate = dateFormat.format(tuesdayDate);
            map.put("convertedTuesdayDate", convertedTuesdayDate);

            calendar.add(Calendar.DATE, +2);
            Date thursdayDate = calendar.getTime();
            convertedThursdayDate = dateFormat.format(thursdayDate);
            map.put("convertedThursdayDate", convertedThursdayDate);

            calendar.add(Calendar.DATE, +1);
            Date fridayDate = calendar.getTime();
            convertedFridayDate = dateFormat.format(fridayDate);
            map.put("convertedFridayDate", convertedFridayDate);

            calendar.add(Calendar.DATE, +1);
            Date saturdayDate = calendar.getTime();
            convertedSaturdayDate = dateFormat.format(saturdayDate);
            map.put("convertedSaturdayDate", convertedSaturdayDate);

        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 5) {

            Date thursdayDate = new Date();
            convertedThursdayDate = dateFormat.format(thursdayDate);
            map.put("convertedThursdayDate", convertedThursdayDate);

            calendar.add(Calendar.DATE, -4);
            Date sundayDate = calendar.getTime();
            convertedSundayDate = dateFormat.format(sundayDate);
            map.put("convertedSundayDate", convertedSundayDate);

            calendar.add(Calendar.DATE, +1);
            Date mondayDate = calendar.getTime();
            convertedMondayDate = dateFormat.format(mondayDate);
            map.put("convertedMondayDate", convertedMondayDate);

            calendar.add(Calendar.DATE, +1);
            Date tuesdayDate = calendar.getTime();
            convertedTuesdayDate = dateFormat.format(tuesdayDate);
            map.put("convertedTuesdayDate", convertedTuesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date wednesdayDate = calendar.getTime();
            convertedWednesdayDate = dateFormat.format(wednesdayDate);
            map.put("convertedWednesdayDate", convertedWednesdayDate);

            calendar.add(Calendar.DATE, +2);
            Date fridayDate = calendar.getTime();
            convertedFridayDate = dateFormat.format(fridayDate);
            map.put("convertedFridayDate", convertedFridayDate);

            calendar.add(Calendar.DATE, +1);
            Date saturdayDate = calendar.getTime();
            convertedSaturdayDate = dateFormat.format(saturdayDate);
            map.put("convertedSaturdayDate", convertedSaturdayDate);

        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 6) {

            Date fridayDate = new Date();
            convertedFridayDate = dateFormat.format(fridayDate);
            map.put("convertedFridayDate", convertedFridayDate);

            calendar.add(Calendar.DATE, -5);
            Date sundayDate = calendar.getTime();
            convertedSundayDate = dateFormat.format(sundayDate);
            map.put("convertedSundayDate", convertedSundayDate);

            calendar.add(Calendar.DATE, +1);
            Date mondayDate = calendar.getTime();
            convertedMondayDate = dateFormat.format(mondayDate);
            map.put("convertedMondayDate", convertedMondayDate);

            calendar.add(Calendar.DATE, +1);
            Date tuesdayDate = calendar.getTime();
            convertedTuesdayDate = dateFormat.format(tuesdayDate);
            map.put("convertedTuesdayDate", convertedTuesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date wednesdayDate = calendar.getTime();
            convertedWednesdayDate = dateFormat.format(wednesdayDate);
            map.put("convertedWednesdayDate", convertedWednesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date thursdayDate = calendar.getTime();
            convertedThursdayDate = dateFormat.format(thursdayDate);
            map.put("convertedThursdayDate", convertedThursdayDate);

            calendar.add(Calendar.DATE, +2);
            Date saturdayDate = calendar.getTime();
            convertedSaturdayDate = dateFormat.format(saturdayDate);
            map.put("convertedSaturdayDate", convertedSaturdayDate);

        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 7) {

            Date saturdayDate = new Date();
            convertedSaturdayDate = dateFormat.format(saturdayDate);
            map.put("convertedSaturdayDate", convertedSaturdayDate);

            calendar.add(Calendar.DATE, -6);
            Date sundayDate = calendar.getTime();
            convertedSundayDate = dateFormat.format(sundayDate);
            map.put("convertedSundayDate", convertedSundayDate);

            calendar.add(Calendar.DATE, +1);
            Date mondayDate = calendar.getTime();
            convertedMondayDate = dateFormat.format(mondayDate);
            map.put("convertedMondayDate", convertedMondayDate);

            calendar.add(Calendar.DATE, +1);
            Date tuesdayDate = calendar.getTime();
            convertedTuesdayDate = dateFormat.format(tuesdayDate);
            map.put("convertedTuesdayDate", convertedTuesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date wednesdayDate = calendar.getTime();
            convertedWednesdayDate = dateFormat.format(wednesdayDate);
            map.put("convertedWednesdayDate", convertedWednesdayDate);

            calendar.add(Calendar.DATE, +1);
            Date thursdayDate = calendar.getTime();
            convertedThursdayDate = dateFormat.format(thursdayDate);
            map.put("convertedThursdayDate", convertedThursdayDate);

            calendar.add(Calendar.DATE, +1);
            Date fridayDate = calendar.getTime();
            convertedFridayDate = dateFormat.format(fridayDate);
            map.put("convertedFridayDate", convertedFridayDate);
        }

        return map;

    }
}


