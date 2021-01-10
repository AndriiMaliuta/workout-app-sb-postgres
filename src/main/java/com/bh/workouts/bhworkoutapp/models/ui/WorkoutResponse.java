package com.bh.workouts.bhworkoutapp.models.ui;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import com.bh.workouts.bhworkoutapp.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutResponse {

    private Long id;

    private String workoutType;

    private String imagePath;

    private List<Exercise> exercises;

    private int sets;

    private Date creationDate;

    private String workoutMonth;

    private String workoutDate;

    private String workoutTime;

    private String workoutDay;

    private User user;

    private String comments;

    private int week;

}
