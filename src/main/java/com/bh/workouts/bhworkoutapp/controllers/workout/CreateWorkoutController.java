package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.WorkoutColorService;
import com.bh.workouts.bhworkoutapp.services.dates.WorkoutDateTrimToMonthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class CreateWorkoutController {

    private final UserService userService;
    private final WorkoutRepository workoutRepository;

    private Logger logger = LoggerFactory.getLogger(CreateWorkoutController.class);

    @Autowired
    public CreateWorkoutController(UserService userService,
                                   WorkoutRepository workoutRepository) {
        this.userService = userService;
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/workout/new")
    public String getCreateForm(Model model) {

        model.addAttribute("workout", new Workout());

        return "workouts/create-workout";
    }

    @PostMapping("/workout/new")
    public String createWorkout(@ModelAttribute Workout workout, Model model) throws ParseException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(auth.getName());

        Workout newWorkout = new Workout();

        newWorkout.setWorkoutType(workout.getWorkoutType());
        newWorkout.setCreationDate(workout.getCreationDate());
        newWorkout.setWorkoutDate(workout.getWorkoutDate());
        newWorkout.setWorkoutMonth(WorkoutDateTrimToMonthService.getTrimmedMonthFromDate(workout.getWorkoutDate()));
        newWorkout.setImagePath(WorkoutColorService.workoutColorSet(workout.getWorkoutType()));
        newWorkout.setComments(workout.getComments());
        newWorkout.setUser(userByLogin);

        Date dayDate = new SimpleDateFormat("MM/dd/yyyy").parse(workout.getWorkoutDate());

        newWorkout.setWorkoutDay(new SimpleDateFormat("EEEE").format(dayDate));

        workoutRepository.save(newWorkout);

        model.addAttribute("newWorkout", newWorkout);

        return "redirect:/workout/" + newWorkout.getId();
    }

}
