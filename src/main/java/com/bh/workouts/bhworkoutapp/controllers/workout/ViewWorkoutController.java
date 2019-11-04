package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.exercise.GetSetsForWorkoutService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final AuthInitiatorService authInitiatorService;
    private final WorkoutService workoutService;

    @Autowired
    public ViewWorkoutController(WorkoutRepository workoutRepository,
                                 AuthInitiatorService authInitiatorService,
                                 WorkoutService workoutService) {
        this.workoutRepository = workoutRepository;
        this.authInitiatorService = authInitiatorService;
        this.workoutService = workoutService;
    }

    @RequestMapping("/workouts/view")
    public String getWorkouts(Model model) {

        List<Workout> workouts = workoutRepository.findAll();

        model.addAttribute("userWorkouts", workoutService.userWorkouts(workouts, authInitiatorService.getUserFromAuth()));
        model.addAttribute("userByLogin", authInitiatorService.getUserFromAuth());

        return "workouts/workouts";
    }

    @GetMapping("/workout/{id}")
    public String viewWorkout(@PathVariable Long id, Model model) {

        Workout workout = workoutRepository.findById(id).get();

        int allSetsCount = GetSetsForWorkoutService.getWorkoutSets(workout);

        model.addAttribute("workout", workout);
        model.addAttribute("userByLogin", authInitiatorService.getUserFromAuth());
        model.addAttribute("allSetsCount", allSetsCount);

        logger.info("================ Viewing workout page: " + workout.getWorkoutType());
        logger.info(workout.getId().toString());
        logger.info(workout.getWorkoutDay());

        return "workouts/workout";
    }


}
