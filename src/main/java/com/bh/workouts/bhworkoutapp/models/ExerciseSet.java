package com.bh.workouts.bhworkoutapp.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exercise_id", referencedColumnName = "exercise_id", nullable = false)
    private Exercise exercise;


}
