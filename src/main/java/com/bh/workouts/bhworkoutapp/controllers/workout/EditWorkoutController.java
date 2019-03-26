package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.dates.DayOfWeekService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.WorkoutColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class EditWorkoutController {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;

    @Autowired
    public EditWorkoutController(WorkoutRepository workoutRepository,
                                 UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @GetMapping("/workout/{id}/edit")
    public String getEditForm(Model model, @PathVariable long id) {

        model.addAttribute("workout", workoutRepository.findById(id).get());

        return "workouts/edit-workout";
    }

    @PostMapping("/workout/edit")
    public String editWorkout(@ModelAttribute Workout workout) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(auth.getName());

        workout.setImagePath(WorkoutColorService.workoutColorSet(workout.getWorkoutType()));
        workout.setCreationDate(new Date());
        workout.setWorkoutDay(DayOfWeekService.dayOfWeek());
        workout.setUser(userByLogin);

        workoutRepository.save(workout);

        return "redirect:/workout/" + workout.getId();
    }
}
