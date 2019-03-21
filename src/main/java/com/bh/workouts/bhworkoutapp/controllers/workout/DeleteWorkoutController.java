package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteWorkoutController {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public DeleteWorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/workout/{id}/delete")
    public String deleteWorkout(@PathVariable long id) {

        workoutRepository.deleteById(id);

        return "redirect:workouts/view";
    }
}
