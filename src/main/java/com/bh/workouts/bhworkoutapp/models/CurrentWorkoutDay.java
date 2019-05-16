package com.bh.workouts.bhworkoutapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "current_week_days")
@Getter
@Setter
@NoArgsConstructor
public class CurrentWorkoutDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "current_workout_day_id")
    private long id;

    private String title;
    private String todayWeekDate;
    private String dayName;
    private int dayNumber;
    private int year;
    private String monthName;
    private int week;

}
