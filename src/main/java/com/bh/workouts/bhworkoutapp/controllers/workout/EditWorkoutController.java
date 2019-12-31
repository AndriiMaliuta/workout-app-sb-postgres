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

    @GetMapping("/workout/{workoutId}/edit")
    public String getEditForm(Model model, @PathVariable long workoutId) {

        model.addAttribute("workout", workoutRepository.findById(workoutId).get());

        return "workouts/edit-workout";
    }

    @PostMapping("/workout/{workoutId}/edit")
    public String editWorkout(@PathVariable long workoutId, @ModelAttribute Workout workout) {

        Workout workoutFromDb = workoutRepository.getOne(workoutId);

        workout.setWorkoutType(workout.getWorkoutType());
        workout.setWorkoutDate(workout.getWorkoutDate());
        workout.setComments(workout.getComments());

        workout.setImagePath(workoutFromDb.getWorkoutType());
        workout.setWorkoutDay(workoutFromDb.getWorkoutDay());
        workout.setUser(workoutFromDb.getUser());
        workout.setCreationDate(workoutFromDb.getCreationDate());
        workout.setWorkoutMonth(workoutFromDb.getWorkoutMonth());
        workout.setImagePath(workoutFromDb.getImagePath());
        workout.setWeek(workoutFromDb.getWeek());
        workout.setWorkoutDay(workoutFromDb.getWorkoutDay());

        workoutRepository.save(workout);

        return "redirect:/workout/" + workout.getId();
    }
}
