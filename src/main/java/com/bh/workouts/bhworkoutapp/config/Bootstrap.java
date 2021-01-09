package com.bh.workouts.bhworkoutapp.config;

import com.bh.workouts.bhworkoutapp.models.RoleEnum;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.user.UserService;
import com.bh.workouts.bhworkoutapp.services.exercise.InitExercisesService;
import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserService userService;
    private final ExerciseNameRepository exerciseNameRepository;
    private final InitExercisesService initExercisesService;
    private final WorkoutRepository workoutRepository;

    private final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    public Bootstrap(UserService userService,
                     ExerciseNameRepository exerciseNameRepository,
                     InitExercisesService initExercisesService,
                     WorkoutRepository workoutRepository) {
        this.userService = userService;
        this.exerciseNameRepository = exerciseNameRepository;
        this.initExercisesService = initExercisesService;
        this.workoutRepository = workoutRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadUsers();
        loadExercises();

        logger.debug("============== Exercises loaded ===============");

    }

    private void loadUsers() {

        if (userService.findAllUsers().size() == 0) {

            User anma = new User();

            anma.setId(1L);
            anma.setRoles(RoleEnum.ROLE_ADMIN + "," + RoleEnum.ROLE_USER);
            anma.setActive(1);
            anma.setEmail("test-main@test.com");
            anma.setLogin("anma");
//            anma.setUsername("anma");
            anma.setFirstName("Andrii");
            anma.setLastName("Maliuta");
            anma.setPassword("Porkie");
            anma.setAge(30);
            anma.setWeight(83);
            anma.setSex("M");
            anma.setHeight(174);

            userService.saveUser(anma);
        }

        logger.debug("=======");
        logger.debug("User created!");

    }

    private void loadExercises () throws IOException {

        if (exerciseNameRepository.findAll().size() == 0) {

            initExercisesService.initExercises();
        }
    }

//    private void setCorrectWeeks() {
//        for (Workout w : workoutRepository.findAll()) {
//            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
//                Date date = null;
//
//                try {
//
//                    date = format.parse(w.getWorkoutDate());
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTime(date);
//                    int weekFromWorkout = cal.get(Calendar.WEEK_OF_MONTH);
//                    w.setWeek(weekFromWorkout);
//                    workoutRepository.save(w);
//
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//        }
//        Workout workout = workoutRepository.findById(453L).get();
//        workout.setWeek(2);
//        workoutRepository.save(workout);
//    }
}
