package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentMonthDaysService;
import com.bh.workouts.bhworkoutapp.services.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.YearMonth;
import java.util.List;

@Controller
public class CurrentMonthWorkoutViewController {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;

    @Autowired
    public CurrentMonthWorkoutViewController(WorkoutRepository workoutRepository,
                                             UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @RequestMapping("/workouts/month")
    public String getWorkoutsMonthView(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        List<Workout> workouts = workoutRepository.findAll();

        YearMonth yearMonth = YearMonth.now();

        model.addAttribute("userWorkouts", GetSpecificUserWorkoutsService.userWorkouts(workouts, userByLogin));
        model.addAttribute("currentDayMap", CurrentMonthDaysService.getMonthDays(yearMonth));

        return "workouts/workouts-month";
    }
}
