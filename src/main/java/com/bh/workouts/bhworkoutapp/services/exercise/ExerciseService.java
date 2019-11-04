package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;

public interface ExerciseService {

    public Exercise findByTitle(String title);

}