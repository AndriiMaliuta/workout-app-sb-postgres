package com.bh.workouts.bhworkoutapp.services.exercise;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.ExerciseNameAccess;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.WorkoutType;
import com.bh.workouts.bhworkoutapp.repositories.ExerciseNameRepository;
import com.bh.workouts.bhworkoutapp.repositories.UserRepository;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    public void initExercises() {

        User commonUser = new User();

        commonUser.setId(1000L);
        commonUser.setActive(1);
        commonUser.setPassword("common");
        commonUser.setEmail("test222@mail.com");
        commonUser.setFirstName("common");
        commonUser.setLastName("common");
        commonUser.setLogin("common");

        userService.saveUser(commonUser);

        // BICEPS

        ExerciseName biceps1 = new ExerciseName();
//        biceps1.setUser(commonUser);
        biceps1.setName("Incline Dumbbell Hammer Curl");
        biceps1.setCategory(WorkoutType.BICEPS.toString());
        biceps1.setAccess(ExerciseNameAccess.COMMON.name());
        exerciseNameRepository.save(biceps1);

        ExerciseName biceps2 = new ExerciseName();
//        biceps2.setUser(commonUser);
        biceps2.setName("Incline Inner-Biceps Curl");
        biceps2.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps2);

        ExerciseName biceps3 = new ExerciseName();
//        biceps3.setUser(commonUser);
        biceps3.setName("Standing Concentration Dumbbell Curl");
        biceps3.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps3);

        ExerciseName biceps4 = new ExerciseName();
//        biceps4.setUser(commonUser);
        biceps4.setName("EZ-Bar Curl");
        biceps4.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps4);

        ExerciseName biceps5 = new ExerciseName();
//        biceps5.setUser(commonUser);
        biceps5.setName("Wide-Grip Standing Barbell Curl");
        biceps5.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps5);

        ExerciseName biceps6 = new ExerciseName();
        biceps6.setUser(commonUser);
        biceps6.setName("Zottman Curl");
        biceps6.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps6);

        ExerciseName biceps7 = new ExerciseName();
//        biceps7.setUser(commonUser);
        biceps7.setName("Regular-Grip Barbell Curl 1 Hand");
        biceps7.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps7);

        ExerciseName biceps8 = new ExerciseName();
//        biceps8.setUser(commonUser);
        biceps8.setName("Regular-Grip Barbell Curl 2 Hands");
        biceps8.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps8);

        ExerciseName biceps9 = new ExerciseName();
//        biceps9.setUser(commonUser);
        biceps9.setName("Dumbbell Biceps Curl");
        biceps9.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps9);

        ExerciseName biceps10 = new ExerciseName();
//        biceps10.setUser(commonUser);
        biceps10.setName("Hammer Curl");
        biceps10.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps10);

        ExerciseName biceps11 = new ExerciseName();
//        biceps11.setUser(commonUser);
        biceps11.setName("Overhead Cable Curl");
        biceps11.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameRepository.save(biceps11);

        // PECS

        ExerciseName pecsExercise1 = new ExerciseName();
        pecsExercise1.setCategory(WorkoutType.PECS.toString());
        pecsExercise1.setName("Barbell Bench Press");
//        pecsExercise1.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise1);

        ExerciseName pecsExercise2 = new ExerciseName();
        pecsExercise2.setCategory(WorkoutType.PECS.toString());
        pecsExercise2.setName("Incline Bench Press");
//        pecsExercise2.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise2);

        ExerciseName pecsExercise3 = new ExerciseName();
        pecsExercise3.setCategory(WorkoutType.PECS.toString());
        pecsExercise3.setName("Decline Bench Press");
//        pecsExercise3.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise3);

        ExerciseName pecsExercise4 = new ExerciseName();
        pecsExercise4.setCategory(WorkoutType.PECS.toString());
        pecsExercise4.setName("Hammer Flat Bench Press");
//        pecsExercise4.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise4);

        ExerciseName pecsExercise5 = new ExerciseName();
        pecsExercise5.setCategory(WorkoutType.PECS.toString());
        pecsExercise5.setName("Hammer Incline Bench Press");
//        pecsExercise5.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise5);

        ExerciseName pecsExercise6 = new ExerciseName();
        pecsExercise6.setCategory(WorkoutType.PECS.toString());
        pecsExercise6.setName("Hammer Sitting Bench Press");
//        pecsExercise6.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise6);

        ExerciseName pecsExercise7 = new ExerciseName();
        pecsExercise7.setCategory(WorkoutType.PECS.toString());
        pecsExercise7.setName("Dumb-bells Flat Bench Press");
//        pecsExercise7.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise7);

        ExerciseName pecsExercise8 = new ExerciseName();
        pecsExercise8.setCategory(WorkoutType.PECS.toString());
        pecsExercise8.setName("Dumb-bells Incline Bench Press");
//        pecsExercise8.setUser(commonUser);
        exerciseNameRepository.save(pecsExercise8);

//        ExerciseName pecsExercise9 = new ExerciseName();
//        pecsExercise9.setCategory(WorkoutType.PECS.toString());
//        pecsExercise9.setName("Dumb-bells Decline Bench Press");
//        pecsExercise9.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise9);
//
//        ExerciseName pecsExercise10 = new ExerciseName();
//        pecsExercise10.setCategory(WorkoutType.PECS.toString());
//        pecsExercise10.setName("Dumbbell Flys");
//        pecsExercise10.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise10);
//
//        ExerciseName pecsExercise11 = new ExerciseName();
//        pecsExercise11.setCategory(WorkoutType.PECS.toString());
//        pecsExercise11.setName("Dumbbell Flys Incline");
//        pecsExercise11.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise11);
//
//        ExerciseName pecsExercise12 = new ExerciseName();
//        pecsExercise12.setCategory(WorkoutType.PECS.toString());
//        pecsExercise12.setName("Hammer Machine Flys");
//        pecsExercise12.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise12);
//
//        ExerciseName pecsExercise13 = new ExerciseName();
//        pecsExercise13.setCategory(WorkoutType.PECS.toString());
//        pecsExercise13.setName("Chest Squeeze Pushup");
//        pecsExercise13.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise13);
//
//        ExerciseName pecsExercise14 = new ExerciseName();
//        pecsExercise14.setCategory(WorkoutType.PECS.toString());
//        pecsExercise14.setName("Cable Fly");
//        pecsExercise14.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise14);
//
//        ExerciseName pecsExercise15 = new ExerciseName();
//        pecsExercise15.setCategory(WorkoutType.PECS.toString());
//        pecsExercise15.setName("Wide-grip Push Ups");
//        pecsExercise15.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise15);
//
//        ExerciseName pecsExercise16 = new ExerciseName();
//        pecsExercise16.setCategory(WorkoutType.PECS.toString());
//        pecsExercise16.setName("Dumbbell Around The World");
//        pecsExercise16.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise16);
//
//        ExerciseName pecsExercise17 = new ExerciseName();
//        pecsExercise17.setCategory(WorkoutType.PECS.toString());
//        pecsExercise17.setName("Suspended Push Ups");
//        pecsExercise17.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise17);
//
//        ExerciseName pecsExercise18 = new ExerciseName();
//        pecsExercise18.setCategory(WorkoutType.PECS.toString());
//        pecsExercise18.setName("Bars Dips");
//        pecsExercise18.setUser(commonUser);
//        exerciseNameRepository.save(pecsExercise18);
//
//        // BACK
//
//        ExerciseName backExercise1 = new ExerciseName();
//        backExercise1.setCategory(WorkoutType.BACK.toString());
//        backExercise1.setName("Barbell Deadlift");
//        backExercise1.setUser(commonUser);
//        exerciseNameRepository.save(backExercise1);
//
//        ExerciseName backExercise2 = new ExerciseName();
//        backExercise2.setCategory(WorkoutType.BACK.toString());
//        backExercise2.setName("Bent-Over Barbell Deadlift");
//        backExercise2.setUser(commonUser);
//        exerciseNameRepository.save(backExercise2);
//
//        ExerciseName backExercise3 = new ExerciseName();
//        backExercise3.setCategory(WorkoutType.BACK.toString());
//        backExercise3.setName("Wide-Grip Pull-Up");
//        backExercise3.setUser(commonUser);
//        exerciseNameRepository.save(backExercise3);
//
//        ExerciseName backExercise4 = new ExerciseName();
//        backExercise4.setCategory(WorkoutType.BACK.toString());
//        backExercise4.setName("Standing T-Bar Row");
//        backExercise4.setUser(commonUser);
//        exerciseNameRepository.save(backExercise4);
//
//        ExerciseName backExercise5 = new ExerciseName();
//        backExercise5.setCategory(WorkoutType.BACK.toString());
//        backExercise5.setName("Wide-Grip Seated Cable Row");
//        backExercise5.setUser(commonUser);
//        exerciseNameRepository.save(backExercise5);
//
//        // DELTS
//
//        ExerciseName deltsExercise1 = new ExerciseName();
//        deltsExercise1.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise1.setName("Bar Press Sitting");
//        deltsExercise1.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise1);
//
//        ExerciseName deltsExercise2 = new ExerciseName();
//        deltsExercise2.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise2.setName("Smith Machine Press");
//        deltsExercise2.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise2);
//
//        ExerciseName deltsExercise3 = new ExerciseName();
//        deltsExercise3.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise3.setName("Kettlebell Pull to Chin");
//        deltsExercise3.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise3);
//
//        ExerciseName deltsExercise4 = new ExerciseName();
//        deltsExercise4.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise4.setName("Barbell Pull to Chin");
//        deltsExercise4.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise4);
//
//        ExerciseName deltsExercise5 = new ExerciseName();
//        deltsExercise5.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise5.setName("Dumbbells Press Standing");
//        deltsExercise5.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise5);
//
//        ExerciseName deltsExercise6 = new ExerciseName();
//        deltsExercise6.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise6.setName("Dumbbells Press Sitting");
//        deltsExercise6.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise6);
//
//        ExerciseName deltsExercise7 = new ExerciseName();
//        deltsExercise7.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise7.setName("Kettlebell Press");
//        deltsExercise7.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise7);
//
//        ExerciseName deltsExercise8 = new ExerciseName();
//        deltsExercise8.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise8.setName("Dumbbells Raises for Middle Delts");
//        deltsExercise8.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise8);
//
//        ExerciseName deltsExercise9 = new ExerciseName();
//        deltsExercise9.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise9.setName("Dumbbells Raises for Back Delts");
//        deltsExercise9.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise9);
//
//        ExerciseName deltsExercise10 = new ExerciseName();
//        deltsExercise10.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise10.setName("Dumbbells Raises for Front Delts");
//        deltsExercise10.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise10);
//
//        ExerciseName deltsExercise11 = new ExerciseName();
//        deltsExercise11.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise11.setName("Bar Press Standing");
//        deltsExercise11.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise11);
//
//        ExerciseName deltsExercise12 = new ExerciseName();
//        deltsExercise12.setCategory(WorkoutType.DELTS.toString());
//        deltsExercise12.setName("Hammer Press Sitting");
//        deltsExercise12.setUser(commonUser);
//        exerciseNameRepository.save(deltsExercise12);
//
//        // TRICEPS
//
//        ExerciseName tricepsExercise1 = new ExerciseName();
//        tricepsExercise1.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise1.setName("Close-grip Bench Press");
//        tricepsExercise1.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise1);
//
//        ExerciseName tricepsExercise2 = new ExerciseName();
//        tricepsExercise2.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise2.setName("Standing Barbell Triceps Extensions");
//        tricepsExercise2.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise2);
//
//        ExerciseName tricepsExercise3 = new ExerciseName();
//        tricepsExercise3.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise3.setName("1-Dumbbell Triceps Overhead Extensions");
//        tricepsExercise3.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise3);
//
//        ExerciseName tricepsExercise4 = new ExerciseName();
//        tricepsExercise4.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise4.setName("Pulley Push-Downs");
//        tricepsExercise4.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise4);
//
//        ExerciseName tricepsExercise5 = new ExerciseName();
//        tricepsExercise5.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise5.setName("Lying Barbell Triceps Extensions");
//        tricepsExercise5.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise5);
//
//        ExerciseName tricepsExercise6 = new ExerciseName();
//        tricepsExercise6.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise6.setName("Dumbbell Squeeze Press");
//        tricepsExercise6.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise6);
//
//        ExerciseName tricepsExercise7 = new ExerciseName();
//        tricepsExercise7.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise7.setName("Cable Pushdowns with Rope");
//        tricepsExercise7.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise7);
//
//        ExerciseName tricepsExercise8 = new ExerciseName();
//        tricepsExercise8.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise8.setName("Triceps Dips");
//        tricepsExercise8.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise8);
//
//        ExerciseName tricepsExercise9 = new ExerciseName(); // ID from 60L
//        tricepsExercise9.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise9.setName("Cable Pushdowns with Flat Handle");
//        tricepsExercise9.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise9);
//
//        ExerciseName tricepsExercise10 = new ExerciseName();
//        tricepsExercise10.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise10.setName("Cable Pushdowns with EZ Handle");
//        tricepsExercise10.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise10);
//
//        ExerciseName tricepsExercise11 = new ExerciseName();
//        tricepsExercise11.setCategory(WorkoutType.TRICEPS.toString());
//        tricepsExercise11.setName("1-Dumbbell Triceps Overback Extensions");
//        tricepsExercise11.setUser(commonUser);
//        exerciseNameRepository.save(tricepsExercise11);
//
//        // ABS
//
//        ExerciseName absExercise1 = new ExerciseName();
//        absExercise1.setCategory(WorkoutType.ABS.toString());
//        absExercise1.setName("Horizontal Crunches");
//        absExercise1.setUser(commonUser);
//        exerciseNameRepository.save(absExercise1);
//
//        ExerciseName absExercise2 = new ExerciseName();
//        absExercise2.setCategory(WorkoutType.ABS.toString());
//        absExercise2.setName("Legs Raises");
//        absExercise2.setUser(commonUser);
//        exerciseNameRepository.save(absExercise2);
//
//        ExerciseName absExercise3 = new ExerciseName();
//        absExercise3.setCategory(WorkoutType.ABS.toString());
//        absExercise3.setName("Crunches");
//        absExercise3.setUser(commonUser);
//        exerciseNameRepository.save(absExercise3);
//
//        ExerciseName absExercise4 = new ExerciseName();
//        absExercise4.setCategory(WorkoutType.ABS.toString());
//        absExercise4.setName("Machine Crunches");
//        absExercise4.setUser(commonUser);
//        exerciseNameRepository.save(absExercise4);
//
//        ExerciseName absExercise5 = new ExerciseName();
//        absExercise5.setCategory(WorkoutType.ABS.toString());
//        absExercise5.setName("Prayer");
//        absExercise5.setUser(commonUser);
//        exerciseNameRepository.save(absExercise5);
//        logger.info("--- ID is --- " + absExercise5.getId());
//        logger.info(absExercise5.getUser().getLogin());

    }

}
