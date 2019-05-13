package com.bh.workouts.bhworkoutapp.repositories;

import com.bh.workouts.bhworkoutapp.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByEmail() {

        User user = userRepository.findByEmail("test-main@test.com");

        assertEquals("anma", user);
    }

    @Test
    public void findByLogin() {

        User user = userRepository.findByLogin("anma");

        assertEquals("Andrii", user.getFirstName());
    }

    @Test
    public void findByLastName() {

        

    }
}