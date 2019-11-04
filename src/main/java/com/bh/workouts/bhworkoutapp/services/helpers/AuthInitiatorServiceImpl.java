package com.bh.workouts.bhworkoutapp.services.helpers;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Profile("PROD")
public class AuthInitiatorServiceImpl implements AuthInitiatorService {

    private final UserService userService;

    @Autowired
    public AuthInitiatorServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getUserFromAuth() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return userService.findUserByLogin(auth.getName());
    }
}
