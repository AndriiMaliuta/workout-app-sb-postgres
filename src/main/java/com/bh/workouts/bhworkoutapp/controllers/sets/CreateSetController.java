package com.bh.workouts.bhworkoutapp.controllers.sets;

import com.bh.workouts.bhworkoutapp.models.ExerciseSet;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseRepository;
import com.bh.workouts.bhworkoutapp.repositories.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateSetController {

    private final SetRepository setRepository;
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public CreateSetController(SetRepository setRepository,
                               ExerciseRepository exerciseRepository) {
        this.setRepository = setRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/exercise/{id}/sets/new")
    public String getSetCreateForm( @PathVariable long id, Model model) {

        model.addAttribute("set", new ExerciseSet());
        model.addAttribute("exercise", exerciseRepository.findById(id).get());

        return "sets/create-set";
    }

    @PostMapping("/exercise/{id}/sets/new")
    public String createExerciseSet(@ModelAttribute ExerciseSet exerciseSet, @PathVariable long id, Model model) {

        ExerciseSet newExerciseSet = new ExerciseSet();

        newExerciseSet.setNumber(exerciseSet.getNumber());
        newExerciseSet.setWeight(exerciseSet.getWeight());
        newExerciseSet.setReps(exerciseSet.getReps());
        newExerciseSet.setBreakInSeconds(exerciseSet.getBreakInSeconds());
        newExerciseSet.setExercise(exerciseRepository.findById(id).get());
        newExerciseSet.setComments(exerciseSet.getComments());

        setRepository.save(newExerciseSet);

        model.addAttribute("newExerciseSet", newExerciseSet);

        return "redirect:/set/" + newExerciseSet.getId() + "/view";
    }
}
