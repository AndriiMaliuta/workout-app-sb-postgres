package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.*;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class InitExercisesService {

    private static Logger logger = LoggerFactory.getLogger(InitExercisesService.class);

    private final ExerciseNameRepository exerciseNameRepository;
    private final UserService userService;

    public InitExercisesService(ExerciseNameRepository exerciseNameRepository,
                                UserService userService) {
        this.exerciseNameRepository = exerciseNameRepository;
        this.userService = userService;
    }

    public void initExercises() throws IOException {

        InputStream inputStream = new ClassPathResource("files/abs-exercises.txt").getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;

            logger.info("++++++++++++++++++++++++++");
            logger.info("Loading exercises");
            logger.info("++++++++++++++++++++++++++");

            while ((line = reader.readLine()) != null) {

                ExerciseName absExercise = new ExerciseName();
                absExercise.setName(line);
                absExercise.setCategory(WorkoutType.ABS.name());
                absExercise.setAccess(ExerciseNameAccess.COMMON.name());
                exerciseNameRepository.save(absExercise);
                logger.info("ABS " + absExercise.getName());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream2 = new ClassPathResource("files/back-exercises.txt").getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream2))) {

            String line;

            while ((line = reader.readLine()) != null) {

                ExerciseName backExercise = new ExerciseName();
                backExercise.setName(line);
                backExercise.setCategory(WorkoutType.BACK.name());
                backExercise.setAccess(ExerciseNameAccess.COMMON.name());
                exerciseNameRepository.save(backExercise);
                logger.info("BACK " + backExercise.getName());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream3 = new ClassPathResource("files/biceps-exercises.txt").getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream3))) {

            String line;

            while ((line = reader.readLine()) != null) {

                ExerciseName bicepsExercise = new ExerciseName();
                bicepsExercise.setName(line);
                bicepsExercise.setCategory(WorkoutType.BICEPS.name());
                bicepsExercise.setAccess(ExerciseNameAccess.COMMON.name());
                exerciseNameRepository.save(bicepsExercise);
                logger.info("BICEPS " + bicepsExercise.getName());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream4 = new ClassPathResource("files/delts-exercises.txt").getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream4))) {

            String line;

            while ((line = reader.readLine()) != null) {

                ExerciseName deltsExercise = new ExerciseName();
                deltsExercise.setName(line);
                deltsExercise.setCategory(WorkoutType.DELTS.name());
                deltsExercise.setAccess(ExerciseNameAccess.COMMON.name());
                exerciseNameRepository.save(deltsExercise);
                logger.info("DELTS " + deltsExercise.getName());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream5 = new ClassPathResource("files/pecs-exercises.txt").getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream5))) {

            String line;

            while ((line = reader.readLine()) != null) {

                ExerciseName pecsExercise = new ExerciseName();
                pecsExercise.setName(line);
                pecsExercise.setCategory(WorkoutType.PECS.name());
                pecsExercise.setAccess(ExerciseNameAccess.COMMON.name());
                exerciseNameRepository.save(pecsExercise);
                logger.info("PECS " + pecsExercise.getName());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream6 = new ClassPathResource("files/triceps-exercises.txt").getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream6))) {

            String line;

            while ((line = reader.readLine()) != null) {

                ExerciseName tricepsExercise = new ExerciseName();
                tricepsExercise.setName(line);
                tricepsExercise.setCategory(WorkoutType.TRICEPS.name());
                tricepsExercise.setAccess(ExerciseNameAccess.COMMON.name());
                exerciseNameRepository.save(tricepsExercise);
                logger.info("TRICS " + tricepsExercise.getName());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
