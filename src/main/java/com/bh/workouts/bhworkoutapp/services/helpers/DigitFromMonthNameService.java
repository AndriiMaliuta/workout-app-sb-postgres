package com.bh.workouts.bhworkoutapp.services.helpers;

public class DigitFromMonthNameService {

    public static int getDigitFromMonth(String monthName) {

        int monthInt = 0;

        switch (monthName) {
            case "JANUARY" : monthInt = 1;
                break;
            case "FEBRUARY" : monthInt = 2;
                break;
            case "MARCH" : monthInt = 3;
                break;
            case "APRIL" : monthInt = 4;
                break;
            case "MAY" : monthInt = 5;
                break;
            case "JUNE" : monthInt = 6;
                break;
            case "JULY" : monthInt = 7;
                break;
            case "AUGUST" : monthInt = 8;
                break;
            case "SEPTEMBER" : monthInt = 9;
                break;
            case "OCTOBER" : monthInt = 10;
                break;
            case "NOVEMBER" : monthInt = 11;
                break;
            case "DECEMBER" : monthInt = 12;
                break;
        }

        return monthInt;
    }
}
