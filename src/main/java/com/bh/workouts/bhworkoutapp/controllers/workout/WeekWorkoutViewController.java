package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentWeekDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WeekWorkoutViewController {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;

    @Autowired
    public WeekWorkoutViewController(WorkoutRepository workoutRepository,
                                     UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @RequestMapping("/workouts/week")
    public String getWorkoutsWeekView(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        List<Workout> workouts = workoutRepository.findAll();

        model.addAttribute("userWorkouts", GetSpecificUserWorkoutsService.userWorkouts(workouts, userByLogin));
        model.addAttribute("daysMap", CurrentWeekDaysService.getCurrentWeekDaysAnsWorkouts());

        return "workouts/workouts-week";
    }
}
