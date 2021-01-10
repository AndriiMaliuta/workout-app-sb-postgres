package com.bh.workouts.bhworkoutapp.models.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutResponse {

    private String type;
    private String date;
    private String comments;

}
