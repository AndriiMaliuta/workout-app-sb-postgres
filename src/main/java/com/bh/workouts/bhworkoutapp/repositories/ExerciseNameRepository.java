package com.bh.workouts.bhworkoutapp.repositories;

import com.bh.workouts.bhworkoutapp.models.ExerciseName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseNameRepository extends JpaRepository<ExerciseName, Long> {

}
