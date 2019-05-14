package com.bh.workouts.bhworkoutapp.repositories;

import com.bh.workouts.bhworkoutapp.models.User;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    @Mock
    User userAnma;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        userAnma.setFirstName("Andrii");
        userAnma.setLogin("anma");
        userAnma.setEmail("test-main@test.com");

    }

    @Test
    public void findByEmail() {

        User user = userRepository.findByEmail("test-main@test.com");

        when(userRepository.findByEmail("test-main@test.com")).thenReturn(userAnma);

        assertEquals(userAnma, userRepository.findByEmail(userAnma.getEmail()));


    }

    @Test
    public void findByLogin() {

        User user = userRepository.findByLogin("anma");

        when(userRepository.findByLogin("anma")).thenReturn(userAnma);

        assertEquals("Andrii", user.getFirstName());

        verify(userRepository.findByLogin("anma"), times(1));
    }

    @Test
    public void findByLastName() {

        

    }
}