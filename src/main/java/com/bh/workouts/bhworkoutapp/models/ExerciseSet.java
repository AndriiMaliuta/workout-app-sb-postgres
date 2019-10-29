package com.bh.workouts.bhworkoutapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sets")
@Data
public class ExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "set_id")
    private long id;
    private int number;
    private int weight;
    private int reps;
    private int breakInSeconds;
    private int setTime;
    private String comments;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exercise_id", referencedColumnName = "exercise_id", nullable = false)
    private Exercise exercise;


}
