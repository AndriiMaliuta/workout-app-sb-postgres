package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.MonthForm;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentMonthDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OtherMonthWorkoutController {

    private final UserService userService;
    private final WorkoutRepository workoutRepository;

    @Autowired
    public OtherMonthWorkoutController(UserService userService, WorkoutRepository workoutRepository) {
        this.userService = userService;
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/workout/other/month")
    public String getOtherMonthForm(Model model) {

        List<String> months = new ArrayList<>();

        months.add("JANUARY");
        months.add("FEBRUARY");
        months.add("MARCH");
        months.add("APRIL");
        months.add("MAY");
        months.add("JUNE");
        months.add("JULY");
        months.add("AUGUST");
        months.add("SEPTEMBER");
        months.add("OCTOBER");
        months.add("NOVEMBER");
        months.add("DECEMBER");

        model.addAttribute("months", months);
        model.addAttribute("monthForm", new MonthForm());

        return "workouts/other-month-form";
    }

    @PostMapping("/workout/other/month")
    public String getOtherMonthPage(@ModelAttribute MonthForm monthForm, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        List<Workout> workouts = workoutRepository.findAll();

        String monthName = monthForm.getMonth();
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

        YearMonth yearMonth = YearMonth.of(monthForm.getYear(), monthInt);

        model.addAttribute("userWorkouts", GetSpecificUserWorkoutsService.userWorkouts(workouts, userByLogin));
        model.addAttribute("currentDayMap", CurrentMonthDaysService.getMonthDays(yearMonth));

        return "workouts/other-month";
    }
}
