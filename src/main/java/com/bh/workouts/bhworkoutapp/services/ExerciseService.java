package com.bh.workouts.bhworkoutapp.services;

import com.bh.workouts.bhworkoutapp.models.Exercise;

public interface ExerciseService {

    public Exercise findByTitle(String title);

}