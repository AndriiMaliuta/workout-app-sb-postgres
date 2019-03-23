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
        biceps1.setCategory("BICEPS");
        exerciseNameService.save(biceps1);

        ExerciseName biceps2 = new ExerciseName();
        biceps2.setId(2L);
        biceps2.setUser(user);
        biceps2.setName("Incline Inner-Biceps Curl");
        biceps2.setCategory("BICEPS");
        exerciseNameService.save(biceps2);

        ExerciseName biceps3 = new ExerciseName();
        biceps3.setId(3L);
        biceps3.setUser(user);
        biceps3.setName("Standing Concentration Dumbbell Curl");
        biceps3.setCategory("BICEPS");
        exerciseNameService.save(biceps3);

        ExerciseName biceps4 = new ExerciseName();
        biceps4.setId(4L);
        biceps4.setUser(user);
        biceps4.setName("EZ-Bar Curl");
        biceps4.setCategory("BICEPS");
        exerciseNameService.save(biceps4);

        ExerciseName biceps5 = new ExerciseName();
        biceps5.setId(5L);
        biceps5.setUser(user);
        biceps5.setName("Wide-Grip Standing Barbell Curl");
        biceps5.setCategory("BICEPS");
        exerciseNameService.save(biceps5);

        ExerciseName biceps6 = new ExerciseName();
        biceps6.setId(6L);
        biceps6.setUser(user);
        biceps6.setName("Zottman Curl");
        biceps6.setCategory("BICEPS");
        exerciseNameService.save(biceps6);

        ExerciseName biceps7 = new ExerciseName();
        biceps7.setId(7L);
        biceps7.setUser(user);
        biceps7.setName("Regular-Grip Barbell Curl 1 Hand");
        biceps7.setCategory("BICEPS");
        exerciseNameService.save(biceps7);

        ExerciseName biceps8 = new ExerciseName();
        biceps8.setId(8L);
        biceps8.setUser(user);
        biceps8.setName("Regular-Grip Barbell Curl 2 Hands");
        biceps8.setCategory("BICEPS");
        exerciseNameService.save(biceps8);

        ExerciseName biceps9 = new ExerciseName();
        biceps9.setId(9L);
        biceps9.setUser(user);
        biceps9.setName("Dumbbell Biceps Curl");
        biceps9.setCategory("BICEPS");
        exerciseNameService.save(biceps9);

        ExerciseName biceps10 = new ExerciseName();
        biceps10.setId(10L);
        biceps10.setUser(user);
        biceps10.setName("Hammer Curl");
        biceps10.setCategory("BICEPS");
        exerciseNameService.save(biceps10);

        ExerciseName biceps11 = new ExerciseName();
        biceps11.setId(11L);
        biceps11.setUser(user);
        biceps11.setName("Overhead Cable Curl");
        biceps11.setCategory("BICEPS");
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

        ExerciseName pecsExercise12 = new ExerciseName();
        pecsExercise12.setId(22L);
        pecsExercise12.setCategory(WorkoutType.PECS.toString());
        pecsExercise12.setName("Hammer Machine Flys");
        pecsExercise12.setUser(user);

        ExerciseName pecsExercise13 = new ExerciseName();
        pecsExercise13.setId(22L);
        pecsExercise13.setCategory(WorkoutType.PECS.toString());
        pecsExercise13.setName("Chest Squeeze Pushup");
        pecsExercise13.setUser(user);

        ExerciseName pecsExercise14 = new ExerciseName();
        pecsExercise14.setId(23L);
        pecsExercise14.setCategory(WorkoutType.PECS.toString());
        pecsExercise14.setName("Cable Fly");
        pecsExercise14.setUser(user);

        ExerciseName pecsExercise15 = new ExerciseName();
        pecsExercise15.setId(24L);
        pecsExercise15.setCategory(WorkoutType.PECS.toString());
        pecsExercise15.setName("Wide-grip Push Ups");
        pecsExercise15.setUser(user);

        ExerciseName pecsExercise16 = new ExerciseName();
        pecsExercise16.setId(25L);
        pecsExercise16.setCategory(WorkoutType.PECS.toString());
        pecsExercise16.setName("Dumbbell Around The World");
        pecsExercise16.setUser(user);

        ExerciseName pecsExercise17 = new ExerciseName();
        pecsExercise17.setId(26L);
        pecsExercise17.setCategory(WorkoutType.PECS.toString());
        pecsExercise17.setName("Suspended Push Ups");
        pecsExercise17.setUser(user);

        ExerciseName pecsExercise18 = new ExerciseName();
        pecsExercise18.setId(27L);
        pecsExercise18.setCategory(WorkoutType.PECS.toString());
        pecsExercise18.setName("Bars Dips");
        pecsExercise18.setUser(user);




    }

}
