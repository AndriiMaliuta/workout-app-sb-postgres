package com.bh.workouts.bhworkoutapp.repositories;

import com.bh.workouts.bhworkoutapp.models.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SetRepository extends JpaRepository<ExerciseSet, Long> {
}
