package com.bh.workouts.bhworkoutapp.thyme.controllers.sets;

import com.bh.workouts.bhworkoutapp.repositories.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewSetController {

    private final SetRepository setRepository;

    @Autowired
    public ViewSetController(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

//    @GetMapping("/exercise/{id}/sets/view")
//    public String getExercises(@PathVariable long id, Model model) {
//
//        model.addAttribute("sets", setRepository.findAll());
//
//        return "sets/sets";
//    }

    @GetMapping("/set/{id}/view")
    public String getWorkout(@PathVariable long id, Model model) {

        model.addAttribute("set", setRepository.findById(id).get());
        model.addAttribute("exercise", setRepository.findById(id).get().getExercise());

        return "sets/set";
    }
}
