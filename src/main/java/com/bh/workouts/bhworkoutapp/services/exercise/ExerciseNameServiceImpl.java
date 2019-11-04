package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseNameServiceImpl implements ExerciseNameService {

    private final ExerciseNameRepository exerciseNameRepository;
    private final AuthInitiatorService authInitiatorService;

    public ExerciseNameServiceImpl(ExerciseNameRepository exerciseNameRepository,
                                   AuthInitiatorService authInitiatorService) {
        this.exerciseNameRepository = exerciseNameRepository;
        this.authInitiatorService = authInitiatorService;
    }

    @Override
    public List<ExerciseName> getOwnExerciseNames(User user) {

        List<ExerciseName> exerciseNames = exerciseNameRepository.findAll();
        List<ExerciseName> userExerciseNames = new ArrayList<>();

        for (ExerciseName exerciseName : exerciseNames) {

            if (exerciseName.getAccess().equals("COMMON")) {
                userExerciseNames.add(exerciseName);
            }

            if (exerciseName.getAccess().equals("PERSONAL")
                    && exerciseName.getUser().equals(authInitiatorService.getUserFromAuth())) {
                userExerciseNames.add(exerciseName);
            }
        }

        return userExerciseNames;

    }
}
