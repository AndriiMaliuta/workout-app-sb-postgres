package com.bh.workouts.bhworkoutapp.controllers.sets;

import com.bh.workouts.bhworkoutapp.models.ExerciseSet;
import com.bh.workouts.bhworkoutapp.repositories.SetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditSetController {

    private final SetRepository setRepository;

    public EditSetController(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @GetMapping("/set/{id}/edit")
    public String getSetEditForm(@PathVariable long id,  Model model) {

        model.addAttribute("set", setRepository.findById(id).get());

        return "sets/edit-set";
    }

    @PostMapping("/set/{id}/edit")
    public String editSet(@ModelAttribute ExerciseSet exerciseSet) {

        setRepository.save(exerciseSet);

        return "redirect:/set/" + exerciseSet.getId() + "/view";
    }

}
