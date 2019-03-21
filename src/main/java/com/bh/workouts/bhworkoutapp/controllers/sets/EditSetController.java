package com.bh.workouts.bhworkoutapp.controllers.sets;

import com.bh.workouts.bhworkoutapp.repositories.SetRepository;
import org.springframework.stereotype.Controller;

@Controller
public class EditSetController {

    private final SetRepository setRepository;

    public EditSetController(SetRepository setRepository) {
        this.setRepository = setRepository;
    }


}
