package com.bh.workouts.bhworkoutapp.models;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "exercises")
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exercise_id")
    private long id;

    @NotNull
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workout_id", referencedColumnName = "workout_id", nullable = false)
    private Workout workout;

    @OneToMany(mappedBy = "exercise")
    private List<ExerciseSet> sets;

    private int weights;

    private int minutes;

    @OneToOne(mappedBy = "exercise")
    private ExerciseName exerciseName;


}
