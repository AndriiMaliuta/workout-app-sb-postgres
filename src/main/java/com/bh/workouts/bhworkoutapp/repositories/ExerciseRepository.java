package com.bh.workouts.bhworkoutapp.repositories;

import com.bh.workouts.bhworkoutapp.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise findByTitle(String title);

}
