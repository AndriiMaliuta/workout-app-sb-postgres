package com.bh.workouts.bhworkoutapp.services.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public List<Workout> findWorkoutsByWorkoutDay(String day) {

        List<Workout> workouts = new ArrayList<>();

        for (Workout workout : workoutRepository.findAll()) {
            if (workout.getWorkoutDay().equals(day)) workouts.add(workout);
        }

        return workouts;
    }

    @Override
    public List<Workout> findWorkoutByWorkoutDate(String date) {

        List<Workout> workouts = new ArrayList<>();

        for (Workout workout : workoutRepository.findAll()) {
            if (workout.getWorkoutDate().equals(date)) workouts.add(workout);
        }

        return workouts;
    }

    @Override
    public List<Workout> userWorkouts(List<Workout> workouts, User userLogin) {

        List<Workout> userWorkouts = new ArrayList<>();

        for (Workout workout : workouts) {

            if (workout.getUser().equals(userLogin)) {
                userWorkouts.add(workout);
            }
        }

        return userWorkouts;
    }

    @Override
    public List<Workout> getWorkoutsByYear(List<Workout> workouts, int year) {

        List<Workout> workoutsByYear = new ArrayList<>();

        for (Workout w : workouts) {
            if (Integer.parseInt(w.getWorkoutDate().substring(6)) == year) {
                workoutsByYear.add(w);
            }

//                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//                Date wDate = dateFormat.parse(w.getWorkoutDate());
//                wDate.getYear()

        }
        return workoutsByYear;
    }
}
