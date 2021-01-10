package com.bh.workouts.bhworkoutapp.models.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkoutRequest {

    private String type;
    private String date;
    private String comments;
}
