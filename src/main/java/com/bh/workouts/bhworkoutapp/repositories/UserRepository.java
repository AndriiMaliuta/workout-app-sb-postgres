package com.bh.workouts.bhworkoutapp.repositories;

import com.bh.workouts.bhworkoutapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
