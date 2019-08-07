//package com.bh.workouts.bhworkoutapp.repositories;
//
//import com.bh.workouts.bhworkoutapp.models.ExerciseName;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ExerciseNameRepositoryIT {
//
//    @Autowired
//    ExerciseNameRepository exerciseNameRepository;
//
//    @Before
//    public void setUp() throws Exception {
//
//
//
//    }
//
//    @Test
//    public void findExerciseNameByUser() {
//
//        List<ExerciseName> exerciseNames = exerciseNameRepository.findAll();
//
//        assertEquals(0, exerciseNames.size());
//
//    }
//}