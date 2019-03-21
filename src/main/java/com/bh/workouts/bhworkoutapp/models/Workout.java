package com.bh.workouts.bhworkoutapp.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workouts")
@Data
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workout_id")
    private Long id;

    @NotEmpty(message = "Please provide workout type")
    @Column(columnDefinition = "varchar(255)")
    private String workoutType;

    private String imagePath;

    @OneToMany(mappedBy = "workout")
    private List<Exercise> exercises;

    private int sets;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationDate;

    private String workoutDate;

    private String workoutTime;

    private String workoutDay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "varchar(500)")
    private String comments;


}
