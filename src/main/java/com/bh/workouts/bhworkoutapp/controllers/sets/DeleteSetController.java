package com.bh.workouts.bhworkoutapp.controllers.sets;

import com.bh.workouts.bhworkoutapp.repositories.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteSetController {

    private final SetRepository setRepository;

    @Autowired
    public DeleteSetController(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @GetMapping("/exercise/{exerciseId}/set/{setId}/delete")
    public String getWorkout(@PathVariable long exerciseId,@PathVariable long setId) {

        setRepository.deleteById(setId);

        return "redirect:/exercise/" + exerciseId + "/view";
    }
}
