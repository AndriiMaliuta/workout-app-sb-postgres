package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.dates.WorkoutDateTrimToMonthService;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        Calendar calendar = Calendar.getInstance();

        workout.setWorkoutType(workout.getWorkoutType());
        workout.setWorkoutDate(workout.getWorkoutDate());
        workout.setComments(workout.getComments());

        workout.setImagePath(WorkoutColorService.workoutColorSet(workout.getWorkoutType()));
        workout.setWorkoutDay(workout.getWorkoutDay());
        workout.setUser(workout.getUser());
        workout.setCreationDate(workout.getCreationDate());
        workout.setWorkoutMonth(workout.getWorkoutMonth());
        workout.setImagePath(workout.getImagePath());
        workout.setWeek(workout.getWeek());
        workout.setWorkoutDay(workout.getWorkoutDay());

        workoutRepository.save(workout);

        return "redirect:/workout/" + workout.getId();
    }
}
