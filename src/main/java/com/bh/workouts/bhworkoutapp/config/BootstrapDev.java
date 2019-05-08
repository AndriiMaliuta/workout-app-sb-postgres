package com.bh.workouts.bhworkoutapp.config;

import com.bh.workouts.bhworkoutapp.models.RoleEnum;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.exercise.InitExercisesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("DEV")
public class BootstrapDev implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(BootstrapDev.class);

    private final UserService userService;
    private final ExerciseNameRepository exerciseNameRepository;

    @Autowired
    public BootstrapDev(UserService userService,
                        ExerciseNameRepository exerciseNameRepository) {
        this.userService = userService;
        this.exerciseNameRepository = exerciseNameRepository;
    }

    private void loadUsers() {

        User anma = new User();

        anma.setId(1L);
        anma.setRoles(RoleEnum.ADMIN);
        anma.setActive(1);
        anma.setEmail("test-main@test.com");
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

    private void loadExercises () {

        InitExercisesService initExercisesService = new InitExercisesService(exerciseNameRepository, userService);

        initExercisesService.initExercises();
    }

    @Override
    public void run(String... args) throws Exception {

        loadUsers();
        loadExercises();

    }
}
