package com.bh.workouts.bhworkoutapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workout_id", referencedColumnName = "workout_id", nullable = false)
    private Workout workout;

    @JsonIgnore
    @OneToMany(mappedBy = "exercise")
    private List<ExerciseSet> sets;

    private int overallWeight;

    private int overallSetsTime;

    private int overallBreakTime;

    private int overallRepsCount;

    private String comments;

//    @OneToOne(mappedBy = "exercise")
//    private ExerciseName exerciseName;


}
