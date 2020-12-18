package com.bh.workouts.bhworkoutapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @JsonIgnore
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active", nullable = false)
    private int active;

    @Column(name = "login")
    @NotEmpty(message = "Please specify your login")
    private String login;

//    @Column(name = "username")
//    @NotEmpty(message = "Please specify your username")
//    private String username;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Please provide valid Email")
    @NotEmpty(message = "*Please provide email")
    private String email;

    private int weight;

    private String sex;

    private int age;

    private int height;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Collection<Role> roles;

    private String roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Workout> workouts;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ExerciseName> exerciseNames;

}
