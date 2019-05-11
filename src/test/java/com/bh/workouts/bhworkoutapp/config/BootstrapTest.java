package com.bh.workouts.bhworkoutapp.config;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
public class BootstrapTest {

    @InjectMocks
    UserService userService;

    private User anma;

    @Mock
    Bootstrap bootstrap;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        anma = new User();
        anma.setLogin("anma");
    }

    @Test
    public void run() {

        bootstrap.loadUsers();

        when(userService.findUserByLogin(any())).thenReturn(anma);

        User user = userService.findUserByLogin("anma");

        assertEquals("anma", user.getLogin());

        verify(userService.findUserByLogin("anma"), times(1));
    }
}