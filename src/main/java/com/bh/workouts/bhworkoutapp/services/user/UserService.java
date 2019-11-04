package com.bh.workouts.bhworkoutapp.services.user;

import com.bh.workouts.bhworkoutapp.models.User;

import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    User findUserByLogin(String login);

    User findUserByLastName(String lastName);

    List<User> findAllUsers();

    void saveUser(User user);
}
