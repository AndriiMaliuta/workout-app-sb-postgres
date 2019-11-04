package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.helpers.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.user.UserServiceImpl;
import com.bh.workouts.bhworkoutapp.services.exercise.GetSetsForWorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ViewWorkoutController {

    private Logger logger = LoggerFactory.getLogger(CreateWorkoutController.class);

    private final WorkoutRepository workoutRepository;
    private final UserServiceImpl userService;

    @Autowired
    public ViewWorkoutController(WorkoutRepository workoutRepository,
                                 UserServiceImpl userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @RequestMapping("/workouts/view")
    public String getWorkouts(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        List<Workout> workouts = workoutRepository.findAll();

        model.addAttribute("userWorkouts", GetSpecificUserWorkoutsService.userWorkouts(workouts, userByLogin));
        model.addAttribute("userByLogin", userByLogin);

        return "workouts/workouts";
    }

    @GetMapping("/workout/{id}")
    public String viewWorkout(@PathVariable Long id, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        Workout workout = workoutRepository.findById(id).get();

        int allSetsCount = GetSetsForWorkoutService.getWorkoutSets(workout);

        model.addAttribute("workout", workout);
        model.addAttribute("userByLogin", userByLogin);
        model.addAttribute("allSetsCount", allSetsCount);

        logger.info("Getting workout " + workout.getWorkoutType());
        logger.info(workout.getId().toString());
        logger.info(workout.getWorkoutDay());

        return "workouts/workout";
    }


}
