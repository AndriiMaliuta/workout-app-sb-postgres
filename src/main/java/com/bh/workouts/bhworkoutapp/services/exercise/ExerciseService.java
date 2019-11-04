package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;

import java.util.List;

public interface ExerciseService {

    Exercise findByTitle(String title);
    
    List<ExerciseName> getExercisesListByUserAndType(List<ExerciseName> list, String workoutType, User user);

}