package com.bh.workouts.bhworkoutapp.repositories;

import com.bh.workouts.bhworkoutapp.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
