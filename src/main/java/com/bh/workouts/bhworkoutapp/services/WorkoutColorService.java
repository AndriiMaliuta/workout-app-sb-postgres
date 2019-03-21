package com.bh.workouts.bhworkoutapp.services;

public class WorkoutColorService {

    public static String workoutColorSet(String workoutType) {

        switch (workoutType) {

            case "PECS" : return "../../images/colors/pecs_new.png";
            case "TRICEPS" : return "../../images/colors/trics_new.png";
            case "BICEPS" : return "../../images/colors/bics_new.png";
            case "DELTS" : return "../../images/colors/delts_new.png";
            case "BACK" : return "../../images/colors/back_new.png";
            case "CALVES" : return "../../images/colors/calves_new.png";
            case "QUADS" : return "../../images/colors/quads_new.png";
            case "FOREARMS" : return "../../images/colors/forearms_new.png";
            case "ABS" : return "../../images/colors/abs_new.png";
            case "TRAPS" : return "../../images/colors/traps_new.png";

            default : return "";
        }

    }
}
