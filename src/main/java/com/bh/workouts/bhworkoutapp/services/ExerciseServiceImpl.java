package com.bh.workouts.bhworkoutapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;;

@Controller
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    public Exercise findByTitle(String title) {

        for (Exercise e : exerciseRepository.findAll()) {
            if (e.getTitle().equals(title)) return e;
        }

        return new Exercise();
    }

}