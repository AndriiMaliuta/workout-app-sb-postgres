package com.bh.workouts.bhworkoutapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;

import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public StatisticsServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getWorkoutCountsByDatesRange(String dateFrom, String dateTo) {

        List<Workout> workouts = new ArrayList<>();

                                                                            // TODO Finish the code

        return workouts;
        
    }

    @Override
    public Map<String, Integer> getWorkoutsForYear(int year, User user) {

        Map<String, Integer> tempMap = new HashMap<>();

        int januaryNumber = 0;
        int febrNumber = 0;
        int marchNumber = 0;
        int aprilNumber = 0;
        int mayNumber = 0;
        int juneNumber = 0;
        int julyNumber = 0;
        int augustNumber = 0;
        int septemberNumber = 0;
        int octoberNumber = 0;
        int novemberNumber = 0;
        int decemberNumber = 0;

        for (Workout w : workoutRepository.findAll()) {
            switch (w.getWorkoutMonth()) {
                case "January" : januaryNumber++; break;
                case "February" : febrNumber++; break;
                case "March" : marchNumber++; break;
                case "April" : aprilNumber++; break;
                case "May" : mayNumber++; break;
                case "June" : juneNumber++; break;
                case "July" : julyNumber++; break;
                case "August" : augustNumber++; break;
                case "September" : septemberNumber++; break;
                case "October" : octoberNumber++; break;
                case "November" : novemberNumber++; break;
                case "December" : decemberNumber++; break;
            }
        }

        tempMap.put("January", januaryNumber);
        tempMap.put("February", febrNumber);
        tempMap.put("March", marchNumber);
        tempMap.put("April", aprilNumber);
        tempMap.put("May", mayNumber);
        tempMap.put("June", juneNumber);
        tempMap.put("July", julyNumber);
        tempMap.put("August", augustNumber);
        tempMap.put("September", septemberNumber);
        tempMap.put("October", octoberNumber);
        tempMap.put("November", novemberNumber);
        tempMap.put("December", decemberNumber);

        return tempMap;
    }
}