package com.bh.workouts.bhworkoutapp.services;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.WorkoutType;
import org.springframework.stereotype.Service;

@Service
public class InitExercisesService {

    private final ExerciseNameService exerciseNameService;

    public InitExercisesService(ExerciseNameService exerciseNameService) {
        this.exerciseNameService = exerciseNameService;
    }

    public void initExercises(User user) {

        ExerciseName biceps1 = new ExerciseName();
        biceps1.setId(1L);
        biceps1.setUser(user);
        biceps1.setName("Incline Dumbbell Hammer Curl");
        biceps1.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps1);

        ExerciseName biceps2 = new ExerciseName();
        biceps2.setId(2L);
        biceps2.setUser(user);
        biceps2.setName("Incline Inner-Biceps Curl");
        biceps2.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps2);

        ExerciseName biceps3 = new ExerciseName();
        biceps3.setId(3L);
        biceps3.setUser(user);
        biceps3.setName("Standing Concentration Dumbbell Curl");
        biceps3.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps3);

        ExerciseName biceps4 = new ExerciseName();
        biceps4.setId(4L);
        biceps4.setUser(user);
        biceps4.setName("EZ-Bar Curl");
        biceps4.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps4);

        ExerciseName biceps5 = new ExerciseName();
        biceps5.setId(5L);
        biceps5.setUser(user);
        biceps5.setName("Wide-Grip Standing Barbell Curl");
        biceps5.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps5);

        ExerciseName biceps6 = new ExerciseName();
        biceps6.setId(6L);
        biceps6.setUser(user);
        biceps6.setName("Zottman Curl");
        biceps6.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps6);

        ExerciseName biceps7 = new ExerciseName();
        biceps7.setId(7L);
        biceps7.setUser(user);
        biceps7.setName("Regular-Grip Barbell Curl 1 Hand");
        biceps7.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps7);

        ExerciseName biceps8 = new ExerciseName();
        biceps8.setId(8L);
        biceps8.setUser(user);
        biceps8.setName("Regular-Grip Barbell Curl 2 Hands");
        biceps8.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps8);

        ExerciseName biceps9 = new ExerciseName();
        biceps9.setId(9L);
        biceps9.setUser(user);
        biceps9.setName("Dumbbell Biceps Curl");
        biceps9.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps9);

        ExerciseName biceps10 = new ExerciseName();
        biceps10.setId(10L);
        biceps10.setUser(user);
        biceps10.setName("Hammer Curl");
        biceps10.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps10);

        ExerciseName biceps11 = new ExerciseName();
        biceps11.setId(11L);
        biceps11.setUser(user);
        biceps11.setName("Overhead Cable Curl");
        biceps11.setCategory(WorkoutType.BICEPS.toString());
        exerciseNameService.save(biceps11);

        ExerciseName pecsExercise1 = new ExerciseName();
        pecsExercise1.setId(12L);
        pecsExercise1.setCategory(WorkoutType.PECS.toString());
        pecsExercise1.setName("Barbell Bench Press");
        pecsExercise1.setUser(user);
        exerciseNameService.save(pecsExercise1);

        ExerciseName pecsExercise2 = new ExerciseName();
        pecsExercise2.setId(13L);
        pecsExercise2.setCategory(WorkoutType.PECS.toString());
        pecsExercise2.setName("Incline Bench Press");
        pecsExercise2.setUser(user);
        exerciseNameService.save(pecsExercise2);

        ExerciseName pecsExercise3 = new ExerciseName();
        pecsExercise3.setId(14L);
        pecsExercise3.setCategory(WorkoutType.PECS.toString());
        pecsExercise3.setName("Decline Bench Press");
        pecsExercise3.setUser(user);
        exerciseNameService.save(pecsExercise3);

        ExerciseName pecsExercise4 = new ExerciseName();
        pecsExercise4.setId(15L);
        pecsExercise4.setCategory(WorkoutType.PECS.toString());
        pecsExercise4.setName("Hammer Flat Bench Press");
        pecsExercise4.setUser(user);
        exerciseNameService.save(pecsExercise4);

        ExerciseName pecsExercise5 = new ExerciseName();
        pecsExercise5.setId(16L);
        pecsExercise5.setCategory(WorkoutType.PECS.toString());
        pecsExercise5.setName("Hammer Incline Bench Press");
        pecsExercise5.setUser(user);
        exerciseNameService.save(pecsExercise5);

        ExerciseName pecsExercise6 = new ExerciseName();
        pecsExercise6.setId(17L);
        pecsExercise6.setCategory(WorkoutType.PECS.toString());
        pecsExercise6.setName("Hammer Sitting Bench Press");
        pecsExercise6.setUser(user);
        exerciseNameService.save(pecsExercise6);

        ExerciseName pecsExercise7 = new ExerciseName();
        pecsExercise7.setId(18L);
        pecsExercise7.setCategory(WorkoutType.PECS.toString());
        pecsExercise7.setName("Dumb-bells Flat Bench Press");
        pecsExercise7.setUser(user);
        exerciseNameService.save(pecsExercise7);

        ExerciseName pecsExercise8 = new ExerciseName();
        pecsExercise8.setId(19L);
        pecsExercise8.setCategory(WorkoutType.PECS.toString());
        pecsExercise8.setName("Dumb-bells Incline Bench Press");
        pecsExercise8.setUser(user);
        exerciseNameService.save(pecsExercise8);

        ExerciseName pecsExercise9 = new ExerciseName();
        pecsExercise9.setId(20L);
        pecsExercise9.setCategory(WorkoutType.PECS.toString());
        pecsExercise9.setName("Dumb-bells Decline Bench Press");
        pecsExercise9.setUser(user);
        exerciseNameService.save(pecsExercise9);

        ExerciseName pecsExercise10 = new ExerciseName();
        pecsExercise10.setId(21L);
        pecsExercise10.setCategory(WorkoutType.PECS.toString());
        pecsExercise10.setName("Dumbbell Flys");
        pecsExercise10.setUser(user);
        exerciseNameService.save(pecsExercise10);

        ExerciseName pecsExercise11 = new ExerciseName();
        pecsExercise11.setId(22L);
        pecsExercise11.setCategory(WorkoutType.PECS.toString());
        pecsExercise11.setName("Dumbbell Flys Incline");
        pecsExercise11.setUser(user);
        exerciseNameService.save(pecsExercise11);

        ExerciseName pecsExercise12 = new ExerciseName();
        pecsExercise12.setId(23L);
        pecsExercise12.setCategory(WorkoutType.PECS.toString());
        pecsExercise12.setName("Hammer Machine Flys");
        pecsExercise12.setUser(user);
        exerciseNameService.save(pecsExercise12);

        ExerciseName pecsExercise13 = new ExerciseName();
        pecsExercise13.setId(24L);
        pecsExercise13.setCategory(WorkoutType.PECS.toString());
        pecsExercise13.setName("Chest Squeeze Pushup");
        pecsExercise13.setUser(user);
        exerciseNameService.save(pecsExercise13);

        ExerciseName pecsExercise14 = new ExerciseName();
        pecsExercise14.setId(25L);
        pecsExercise14.setCategory(WorkoutType.PECS.toString());
        pecsExercise14.setName("Cable Fly");
        pecsExercise14.setUser(user);
        exerciseNameService.save(pecsExercise14);

        ExerciseName pecsExercise15 = new ExerciseName();
        pecsExercise15.setId(26L);
        pecsExercise15.setCategory(WorkoutType.PECS.toString());
        pecsExercise15.setName("Wide-grip Push Ups");
        pecsExercise15.setUser(user);
        exerciseNameService.save(pecsExercise15);

        ExerciseName pecsExercise16 = new ExerciseName();
        pecsExercise16.setId(27L);
        pecsExercise16.setCategory(WorkoutType.PECS.toString());
        pecsExercise16.setName("Dumbbell Around The World");
        pecsExercise16.setUser(user);
        exerciseNameService.save(pecsExercise16);

        ExerciseName pecsExercise17 = new ExerciseName();
        pecsExercise17.setId(28L);
        pecsExercise17.setCategory(WorkoutType.PECS.toString());
        pecsExercise17.setName("Suspended Push Ups");
        pecsExercise17.setUser(user);
        exerciseNameService.save(pecsExercise17);

        ExerciseName pecsExercise18 = new ExerciseName();
        pecsExercise18.setId(29L);
        pecsExercise18.setCategory(WorkoutType.PECS.toString());
        pecsExercise18.setName("Bars Dips");
        pecsExercise18.setUser(user);
        exerciseNameService.save(pecsExercise18);

        ExerciseName backExercise1 = new ExerciseName();
        backExercise1.setId(30L);
        backExercise1.setCategory(WorkoutType.BACK.toString());
        backExercise1.setName("Barbell Deadlift");
        backExercise1.setUser(user);
        exerciseNameService.save(backExercise1);

        ExerciseName backExercise2 = new ExerciseName();
        backExercise2.setId(31L);
        backExercise2.setCategory(WorkoutType.BACK.toString());
        backExercise2.setName("Bent-Over Barbell Deadlift");
        backExercise2.setUser(user);
        exerciseNameService.save(backExercise2);

        ExerciseName backExercise3 = new ExerciseName();
        backExercise3.setId(32L);
        backExercise3.setCategory(WorkoutType.BACK.toString());
        backExercise3.setName("Wide-Grip Pull-Up");
        backExercise3.setUser(user);
        exerciseNameService.save(backExercise3);

        ExerciseName backExercise4 = new ExerciseName();
        backExercise4.setId(33L);
        backExercise4.setCategory(WorkoutType.BACK.toString());
        backExercise4.setName("Standing T-Bar Row");
        backExercise4.setUser(user);
        exerciseNameService.save(backExercise4);

        ExerciseName backExercise5 = new ExerciseName();
        backExercise5.setId(34L);
        backExercise5.setCategory(WorkoutType.BACK.toString());
        backExercise5.setName("Wide-Grip Seated Cable Row");
        backExercise5.setUser(user);
        exerciseNameService.save(backExercise5);

        ExerciseName deltsExercise1 = new ExerciseName();
        deltsExercise1.setId(35L);
        deltsExercise1.setCategory(WorkoutType.DELTS.toString());
        deltsExercise1.setName("Bar Press Sitting");
        deltsExercise1.setUser(user);
        exerciseNameService.save(deltsExercise1);

        ExerciseName deltsExercise2 = new ExerciseName();
        deltsExercise2.setId(36L);
        deltsExercise2.setCategory(WorkoutType.DELTS.toString());
        deltsExercise2.setName("Smith Machine Press");
        deltsExercise2.setUser(user);
        exerciseNameService.save(deltsExercise2);

        ExerciseName deltsExercise3 = new ExerciseName();
        deltsExercise3.setId(37L);
        deltsExercise3.setCategory(WorkoutType.DELTS.toString());
        deltsExercise3.setName("Kettlebell Pull to Chin");
        deltsExercise3.setUser(user);
        exerciseNameService.save(deltsExercise3);

        ExerciseName deltsExercise4 = new ExerciseName();
        deltsExercise4.setId(38L);
        deltsExercise4.setCategory(WorkoutType.DELTS.toString());
        deltsExercise4.setName("Barbell Pull to Chin");
        deltsExercise4.setUser(user);
        exerciseNameService.save(deltsExercise4);

        ExerciseName deltsExercise5 = new ExerciseName();
        deltsExercise5.setId(39L);
        deltsExercise5.setCategory(WorkoutType.DELTS.toString());
        deltsExercise5.setName("Dumbbells Press Standing");
        deltsExercise5.setUser(user);
        exerciseNameService.save(deltsExercise5);

        ExerciseName deltsExercise6 = new ExerciseName();
        deltsExercise6.setId(40L);
        deltsExercise6.setCategory(WorkoutType.DELTS.toString());
        deltsExercise6.setName("Dumbbells Press Sitting");
        deltsExercise6.setUser(user);
        exerciseNameService.save(deltsExercise6);

        ExerciseName deltsExercise7 = new ExerciseName();
        deltsExercise7.setId(41L);
        deltsExercise7.setCategory(WorkoutType.DELTS.toString());
        deltsExercise7.setName("Kettlebell Press");
        deltsExercise7.setUser(user);
        exerciseNameService.save(deltsExercise7);

        ExerciseName deltsExercise8 = new ExerciseName();
        deltsExercise8.setId(42L);
        deltsExercise8.setCategory(WorkoutType.DELTS.toString());
        deltsExercise8.setName("Dumbbells Raises for Middle Delts");
        deltsExercise8.setUser(user);
        exerciseNameService.save(deltsExercise8);

        ExerciseName deltsExercise9 = new ExerciseName();
        deltsExercise9.setId(43L);
        deltsExercise9.setCategory(WorkoutType.DELTS.toString());
        deltsExercise9.setName("Dumbbells Raises for Back Delts");
        deltsExercise9.setUser(user);
        exerciseNameService.save(deltsExercise9);

        ExerciseName deltsExercise10 = new ExerciseName();
        deltsExercise10.setId(44L);
        deltsExercise10.setCategory(WorkoutType.DELTS.toString());
        deltsExercise10.setName("Dumbbells Raises for Front Delts");
        deltsExercise10.setUser(user);
        exerciseNameService.save(deltsExercise10);

        ExerciseName deltsExercise11 = new ExerciseName();
        deltsExercise11.setId(45L);
        deltsExercise11.setCategory(WorkoutType.DELTS.toString());
        deltsExercise11.setName("Bar Press Standing");
        deltsExercise11.setUser(user);
        exerciseNameService.save(deltsExercise11);

        ExerciseName deltsExercise12 = new ExerciseName();
        deltsExercise12.setId(46L);
        deltsExercise12.setCategory(WorkoutType.DELTS.toString());
        deltsExercise12.setName("Hammer Press Sitting");
        deltsExercise12.setUser(user);
        exerciseNameService.save(deltsExercise12);

        ExerciseName tricepsExercise1 = new ExerciseName();
        tricepsExercise1.setId(47L);
        tricepsExercise1.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise1.setName("Close-grip Bench Press");
        tricepsExercise1.setUser(user);
        exerciseNameService.save(tricepsExercise1);

        ExerciseName tricepsExercise2 = new ExerciseName();
        tricepsExercise2.setId(48L);
        tricepsExercise2.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise2.setName("Standing Barbell Triceps Extensions");
        tricepsExercise2.setUser(user);
        exerciseNameService.save(tricepsExercise2);

        ExerciseName tricepsExercise3 = new ExerciseName();
        tricepsExercise3.setId(49L);
        tricepsExercise3.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise3.setName("1-Dumbbell Triceps Overhead Extensions");
        tricepsExercise3.setUser(user);
        exerciseNameService.save(tricepsExercise3);

        ExerciseName tricepsExercise4 = new ExerciseName();
        tricepsExercise4.setId(50L);
        tricepsExercise4.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise4.setName("Pulley Push-Downs");
        tricepsExercise4.setUser(user);
        exerciseNameService.save(tricepsExercise4);

        ExerciseName tricepsExercise5 = new ExerciseName();
        tricepsExercise5.setId(51L);
        tricepsExercise5.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise5.setName("Lying Barbell Triceps Extensions");
        tricepsExercise5.setUser(user);
        exerciseNameService.save(tricepsExercise5);

        ExerciseName tricepsExercise6 = new ExerciseName();
        tricepsExercise6.setId(52L);
        tricepsExercise6.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise6.setName("Dumbbell Squeeze Press");
        tricepsExercise6.setUser(user);
        exerciseNameService.save(tricepsExercise6);

        ExerciseName tricepsExercise7 = new ExerciseName();
        tricepsExercise7.setId(53L);
        tricepsExercise7.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise7.setName("Rope Tricep Pushdown");
        tricepsExercise7.setUser(user);
        exerciseNameService.save(tricepsExercise7);

        ExerciseName tricepsExercise8 = new ExerciseName();
        tricepsExercise8.setId(54L);
        tricepsExercise8.setCategory(WorkoutType.TRICEPS.toString());
        tricepsExercise8.setName("Triceps Dips");
        tricepsExercise8.setUser(user);
        exerciseNameService.save(tricepsExercise8);

        ExerciseName absExercise1 = new ExerciseName();
        absExercise1.setId(55L);
        absExercise1.setCategory(WorkoutType.ABS.toString());
        absExercise1.setName("Horizontal Crunches");
        absExercise1.setUser(user);
        exerciseNameService.save(absExercise1);

        ExerciseName absExercise2 = new ExerciseName();
        absExercise2.setId(56L);
        absExercise2.setCategory(WorkoutType.ABS.toString());
        absExercise2.setName("Legs Raises");
        absExercise2.setUser(user);
        exerciseNameService.save(absExercise2);

        ExerciseName absExercise3 = new ExerciseName();
        absExercise3.setId(57L);
        absExercise3.setCategory(WorkoutType.ABS.toString());
        absExercise3.setName("Crunches");
        absExercise3.setUser(user);
        exerciseNameService.save(absExercise3);

        ExerciseName absExercise4 = new ExerciseName();
        absExercise4.setId(58L);
        absExercise4.setCategory(WorkoutType.ABS.toString());
        absExercise4.setName("Machine Crunches");
        absExercise4.setUser(user);
        exerciseNameService.save(absExercise4);

        ExerciseName absExercise5 = new ExerciseName();
        absExercise5.setId(59L);
        absExercise5.setCategory(WorkoutType.ABS.toString());
        absExercise5.setName("Prayer");
        absExercise5.setUser(user);
        exerciseNameService.save(absExercise5);
        
    }

}
