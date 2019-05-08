package com.bh.workouts.bhworkoutapp.config;

import com.bh.workouts.bhworkoutapp.models.RoleEnum;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.exercise.ExerciseNameService;
import com.bh.workouts.bhworkoutapp.services.exercise.InitExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Profile("DEV")
public class Bootstrap implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public Bootstrap(UserService userService) {
        this.userService = userService;
    }

    private void loadData() {

        User anma = new User();
        anma.setId(1L);
        anma.setRoles(RoleEnum.ADMIN);
        anma.setActive(1);
        anma.setEmail("m@m");
        anma.setLogin("anma");
        anma.setFirstName("Andrii");
        anma.setLastName("M");
        anma.setPassword("");
        anma.setAge(30);
        anma.setWeight(82);
        anma.setSex("M");
        anma.setHeight(174);

        userService.saveUser(anma);
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }
}
