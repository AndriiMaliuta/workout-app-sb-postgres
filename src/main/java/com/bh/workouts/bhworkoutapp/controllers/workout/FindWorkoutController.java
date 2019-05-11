package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FindWorkoutController {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;

    @Autowired
    public FindWorkoutController(WorkoutRepository workoutRepository,
                                 UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @GetMapping("/workout/find")
    public String getFindForm(Model model) {

        model.addAttribute("workout", new Workout());

        return "workouts/find-workout";
    }

    @PostMapping("/workout/find")
    public String findWorkoutByName(@ModelAttribute Workout workout, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        String date = workout.getWorkoutDate();

        List<Workout> workouts = workoutRepository.findWorkoutByWorkoutDate(date);
        List<Workout> userWorkouts = GetSpecificUserWorkoutsService.userWorkouts(workouts, userByLogin);

        model.addAttribute("foundUserWorkouts", userWorkouts);

        return "workouts/found-workouts";
    }
}
