package com.bh.workouts.bhworkoutapp.services;


import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseNameService {

    private final ExerciseNameRepository exerciseNameRepository;
    private final UserService userService;


    @Autowired
    public ExerciseNameService(ExerciseNameRepository exerciseNameRepository,
                               UserService userService) {
        this.exerciseNameRepository = exerciseNameRepository;
        this.userService = userService;
    }

    public List<ExerciseName> getUserExerciseNames(User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        List<ExerciseName> exerciseNames = exerciseNameRepository.findAll();
        List<ExerciseName> userExerciseNames = new ArrayList<>();

        for (ExerciseName exerciseName : exerciseNames) {
            if (exerciseName.getUser().equals(userByLogin)) {
                userExerciseNames.add(exerciseName);
            }
        }

        return userExerciseNames;
    }

    public void save (ExerciseName exerciseName) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        exerciseName.setUser(userByLogin);
        exerciseName.setName(exerciseName.getName());

        exerciseNameRepository.save(exerciseName);
    }

}
