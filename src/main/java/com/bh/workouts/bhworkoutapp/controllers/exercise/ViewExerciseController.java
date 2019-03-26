package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import com.bh.workouts.bhworkoutapp.services.exercise.GetExerciseBreakTimeService;
import com.bh.workouts.bhworkoutapp.services.exercise.GetExerciseDurationService;
import com.bh.workouts.bhworkoutapp.services.exercise.GetExerciseRepsService;
import com.bh.workouts.bhworkoutapp.services.exercise.GetExerciseWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ViewExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/exercise/{id}/view")
    public String getExercises(@PathVariable long id, Model model) {

        Exercise exercise = exerciseRepository.findById(id).get();

        int overallExerciseDuration = GetExerciseDurationService.getExerciseDurationTime(exercise);
        int overallExerciseBreakTime = GetExerciseBreakTimeService.getExerciseBreakTime(exercise);
        int overallExerciseReps = GetExerciseRepsService.getExerciseReps(exercise);
        int overallExerciseWeights = GetExerciseWeightService.getExerciseOverallWeight(exercise);

        model.addAttribute("exercise", exercise);
        model.addAttribute("workout", exercise.getWorkout());
        model.addAttribute("overallExerciseDuration", overallExerciseDuration);
        model.addAttribute("overallExerciseBreakTime", overallExerciseBreakTime);
        model.addAttribute("overallExerciseReps", overallExerciseReps);
        model.addAttribute("overallExerciseWeights", overallExerciseWeights);

        return "exercises/exercise";
    }
}
