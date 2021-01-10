package com.bh.workouts.bhworkoutapp.api.v1.models;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import com.bh.workouts.bhworkoutapp.models.Workout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRest {

    private String firstName;

    private String lastName;

    private int active;

    private String login;

    private String email;

    private int weight;

    private String sex;

    private int age;

    private int height;

    private List<Workout> workouts;

    private List<ExerciseName> exerciseNames;
}
