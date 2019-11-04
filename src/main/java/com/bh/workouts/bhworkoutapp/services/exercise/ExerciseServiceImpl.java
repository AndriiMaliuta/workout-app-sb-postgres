package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;;import java.util.ArrayList;
import java.util.List;

@Service
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

    public List<ExerciseName> getExercisesListByUserAndType(List<ExerciseName> list, String workoutType, User user) {

        List<ExerciseName> userWorkoutTypeExercisesList = new ArrayList<>();

        for (ExerciseName exerciseName : list) {

            if (exerciseName.getAccess().equals("COMMON")
                    && exerciseName.getCategory().equalsIgnoreCase(workoutType)) {
                userWorkoutTypeExercisesList.add(exerciseName);
            }

            if (!exerciseName.getAccess().equals("COMMON")) {
                if (exerciseName.getCategory().equalsIgnoreCase(workoutType)
                        && exerciseName.getUser().equals(user)) {

                    userWorkoutTypeExercisesList.add(exerciseName);
                }
            }
        }

        return userWorkoutTypeExercisesList;

    }

}