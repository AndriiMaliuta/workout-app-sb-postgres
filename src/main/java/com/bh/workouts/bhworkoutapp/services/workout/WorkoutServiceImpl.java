package com.bh.workouts.bhworkoutapp.services.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
