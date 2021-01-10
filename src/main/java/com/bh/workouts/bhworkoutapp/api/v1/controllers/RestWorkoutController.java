package com.bh.workouts.bhworkoutapp.api.v1.controllers;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.models.ui.CreateWorkoutRequest;
import com.bh.workouts.bhworkoutapp.models.ui.WorkoutResponse;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.dates.WorkoutDateTrimToMonthService;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutColorService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping(RestWorkoutController.BASE_URL)
@Log
public class RestWorkoutController {

    static final String BASE_URL = "/rest/api/v1/workouts";

    private final WorkoutRepository workoutRepository;
    private final WorkoutService workoutService;
    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public RestWorkoutController(WorkoutRepository workoutRepository, WorkoutService workoutService, AuthInitiatorService authInitiatorService) {
        this.workoutRepository = workoutRepository;
        this.workoutService = workoutService;
        this.authInitiatorService = authInitiatorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Workout> getWorkoutsForApi() {

        return workoutRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Workout getWorkoutByIdApi(@PathVariable long id) {

        return workoutRepository.findById(id).get();
    }

    @GetMapping(path = "/date/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Workout> getWorkoutsByYear(@PathVariable(value = "year") Integer year) {
        return workoutService.getWorkoutsByYear(workoutRepository.findAll(), year);
    }

    @GetMapping(path = "/date/{year}/{month}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Workout> getWorkoutsByYearMonth(@PathVariable(value = "year") Integer year, @PathVariable String month) {
        return workoutService.getWorkoutsByYearMonth(workoutRepository.findAll(), year, month);
    }

    @GetMapping(path = "/date/{year}/{month}/{week}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Workout> getWorkoutsByYearMonthWeek(@PathVariable(value = "year") Integer year,
                                                    @PathVariable String month,
                                                    @PathVariable Integer week) {
        return workoutService.getWorkoutsByYearMonthWeek(workoutRepository.findAll(), year, month, week);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Workout createWorkout(@Valid @RequestBody CreateWorkoutRequest request) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        calendar.setTime(format.parse(request.getDate()));

        Workout workout = new Workout();
        workout.setWorkoutType(request.getType());
        workout.setWorkoutDate(request.getDate());
        workout.setComments(request.getComments());

        workout.setImagePath(WorkoutColorService.workoutColorSet(request.getType()));
//        workout.setCreationDate();
        workout.setWorkoutMonth(WorkoutDateTrimToMonthService.getTrimmedMonthFromDate(request.getDate()));

        workout.setUser(authInitiatorService.getUserFromAuth());
        workout.setWeek(calendar.get(Calendar.WEEK_OF_MONTH));

        Date dayDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getDate());
        workout.setWorkoutDay(new SimpleDateFormat("EEEE").format(dayDate));

        return workoutRepository.save(workout);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Workout> updateWorkout(@RequestBody CreateWorkoutRequest request, @PathVariable long id) {

        log.info(">>>>>>>>>>>>>>>>>> REST PUT request to change workout with ID == " + id);

//        Workout existingWorkout = workoutRepository.getOne(id);
//        existingWorkout.setWorkoutType(request.getType());
//        existingWorkout.setWorkoutDate(request.getDate());
//        existingWorkout.setComments(request.getComments());

        log.info(">>>>>>>>>>>>>>>>>> PUT OK -> Workout changed successfully");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(workoutRepository.save(new ModelMapper().map(request, Workout.class)));
    }
}
