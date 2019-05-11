package com.bh.workouts.bhworkoutapp.services;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    UserService userService;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        userService = new UserService(userRepository, bCryptPasswordEncoder);

    }

    @Test
    public void findUserByEmail() {



    }

    @Test
    public void findUserByLogin() {
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void findAllUsers() {

        List<User> users = userService.findAllUsers();
        List<User> usersList = new ArrayList<>();

        User user = new User();

        usersList.add(user);

        when(userService.findAllUsers()).thenReturn(usersList);

        assertEquals(users.size(), 0);

        verify(userRepository, times(1)).findAll();

        System.out.println(usersList.size());
    }
}