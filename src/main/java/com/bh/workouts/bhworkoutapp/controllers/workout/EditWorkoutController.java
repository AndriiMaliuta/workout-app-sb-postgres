package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.dates.DayOfWeekService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutColorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public EditWorkoutController(WorkoutRepository workoutRepository,
                                 AuthInitiatorService authInitiatorService) {
        this.workoutRepository = workoutRepository;
        this.authInitiatorService = authInitiatorService;
    }

    @GetMapping("/workout/{id}/edit")
    public String getEditForm(Model model, @PathVariable long id) {

        model.addAttribute("workout", workoutRepository.findById(id).get());

        return "workouts/edit-workout";
    }

    @PostMapping("/workout/edit")
    public String editWorkout(@ModelAttribute Workout workout) {

        workout.setImagePath(WorkoutColorService.workoutColorSet(workout.getWorkoutType()));
        workout.setCreationDate(new Date());
        workout.setWorkoutDay(DayOfWeekService.dayOfWeek());
        workout.setUser(authInitiatorService.getUserFromAuth());

        workoutRepository.save(workout);

        return "redirect:/workout/" + workout.getId();
    }
}
