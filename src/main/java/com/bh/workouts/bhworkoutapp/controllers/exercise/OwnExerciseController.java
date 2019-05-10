package com.bh.workouts.bhworkoutapp.controllers.exercise;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.ExerciseNameAccess;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.services.exercise.ExerciseNameService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OwnExerciseController {

    Logger logger = LoggerFactory.getLogger(OwnExerciseController.class);

    private final UserService userService;
    private final ExerciseNameService exerciseNameService;
    private final ExerciseNameRepository exerciseNameRepository;

    @Autowired
    public OwnExerciseController(UserService userService,
                                 ExerciseNameService exerciseNameService,
                                 ExerciseNameRepository exerciseNameRepository) {
        this.userService = userService;
        this.exerciseNameService = exerciseNameService;
        this.exerciseNameRepository = exerciseNameRepository;
    }

    @GetMapping("/exercises/own")
    public String getOwnExercises(Model model) {

        model.addAttribute("ownExercisesList", exerciseNameService.getOwnExerciseNames());

        return "exercises/own-exercises";
    }

    @GetMapping("/exercise/own/add")
    public String getForm(Model model) {

        model.addAttribute("exerciseName", new ExerciseName());

        return "exercises/add-own";

    }

    @PostMapping("/exercise/own/add")
    public String addOwnExercise(@ModelAttribute ExerciseName exerciseName) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User userByLogin = userService.findUserByLogin(authentication.getName());

        exerciseName.setUser(userByLogin);
        exerciseName.setAccess(ExerciseNameAccess.PERSONAL.name());

        exerciseNameRepository.save(exerciseName);

        logger.info(exerciseName.getUser().getLogin());
        logger.info(exerciseName.getAccess());
        logger.info(authentication.getName());

        return "redirect:/exercises/own";
    }

    @GetMapping("/exercise/own/{id}/delete")
    public String deleteWorkout(@PathVariable long id) {

        exerciseNameRepository.deleteById(id);

        return "redirect:/exercises/own";
    }

}
