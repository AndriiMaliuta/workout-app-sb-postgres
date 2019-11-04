package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.dates.WorkoutDateTrimToMonthService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
// @Profile("PROD")
public class CreateWorkoutController {

    private final WorkoutRepository workoutRepository;
    private final AuthInitiatorService authInitiatorService;

    private Logger logger = LoggerFactory.getLogger(CreateWorkoutController.class);

    @Autowired
    public CreateWorkoutController(WorkoutRepository workoutRepository,
                                   AuthInitiatorService authInitiatorService) {
        this.workoutRepository = workoutRepository;
        this.authInitiatorService = authInitiatorService;
    }

    @GetMapping("/workout/new")
    public String getCreateForm(Model model) {

        model.addAttribute("workout", new Workout());

        return "workouts/create-workout";
    }

    @PostMapping("/workout/new")
    public String createWorkout(@ModelAttribute Workout workout, Model model) throws ParseException {

        Calendar calendar = Calendar.getInstance();

        Workout newWorkout = new Workout();

        newWorkout.setWorkoutType(workout.getWorkoutType());
        newWorkout.setCreationDate(workout.getCreationDate());
        newWorkout.setWorkoutDate(workout.getWorkoutDate());
        newWorkout.setWorkoutMonth(WorkoutDateTrimToMonthService.getTrimmedMonthFromDate(workout.getWorkoutDate()));
        newWorkout.setImagePath(WorkoutColorService.workoutColorSet(workout.getWorkoutType()));
        newWorkout.setComments(workout.getComments());
        newWorkout.setUser(authInitiatorService.getUserFromAuth());
        newWorkout.setWeek(calendar.get(Calendar.WEEK_OF_MONTH));

        Date dayDate = new SimpleDateFormat("MM/dd/yyyy").parse(workout.getWorkoutDate());

        newWorkout.setWorkoutDay(new SimpleDateFormat("EEEE").format(dayDate));

        workoutRepository.save(newWorkout);

        model.addAttribute("newWorkout", newWorkout);

        logger.info("===== Workout created: =====");
        logger.info(newWorkout.getId().toString());
        logger.info(newWorkout.getWorkoutType());
        logger.info(newWorkout.getWorkoutDay());

        return "redirect:/workout/" + newWorkout.getId();
    }

}
