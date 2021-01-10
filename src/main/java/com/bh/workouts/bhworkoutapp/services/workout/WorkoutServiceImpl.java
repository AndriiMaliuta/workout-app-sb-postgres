package com.bh.workouts.bhworkoutapp.services.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public List<Workout> findAllWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public List<Workout> findWorkoutsFromTo(String from, String to) {

        List<Workout> workoutsByDatesRange = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        for (Workout w : findAllWorkouts()) {
            try {
                Date wDate = format.parse(w.getWorkoutDate());
                Date fromDate = format.parse(from);
                Date toDate = format.parse(to);
                if ( (wDate.after(fromDate) || wDate.equals(fromDate))
                        && (wDate.before(toDate) || wDate.equals(toDate))) {
                    workoutsByDatesRange.add(w);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return workoutsByDatesRange;
    }

    @Override
    public List<Workout> findWorkoutsByWorkoutDay(String day) {

        List<Workout> workouts = new ArrayList<>();

        for (Workout workout : workoutRepository.findAll()) {
            if (workout.getWorkoutDay().equals(day)) workouts.add(workout);
        }

        return workouts;
    }

    @Override
    public List<Workout> findWorkoutByWorkoutDate(String date) {

        List<Workout> workouts = new ArrayList<>();

        for (Workout workout : workoutRepository.findAll()) {
            if (workout.getWorkoutDate().equals(date)) workouts.add(workout);
        }

        return workouts;
    }

    @Override
    public List<Workout> userWorkouts(List<Workout> workouts, User userLogin) {

        List<Workout> userWorkouts = new ArrayList<>();

        for (Workout workout : workouts) {

            if (workout.getUser().equals(userLogin)) {
                userWorkouts.add(workout);
            }
        }

        return userWorkouts;
    }

    @Override
    public List<Workout> getWorkoutsByYear(List<Workout> workouts, int year) {

        List<Workout> workoutsByYear = new ArrayList<>();

        for (Workout w : workouts) {
            if (Integer.parseInt(w.getWorkoutDate().substring(6)) == year) {
                workoutsByYear.add(w);
            }

//                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//                Date wDate = dateFormat.parse(w.getWorkoutDate());
//                wDate.getYear()

        }
        return workoutsByYear;
    }

    @Override
    public List<Workout> getWorkoutsByYearMonth(List<Workout> workouts, int year, String month) {

        List<Workout> workoutsByYearMonth = new ArrayList<>();

        for (Workout w : workouts) {
            if (Integer.parseInt(w.getWorkoutDate().substring(6)) == year && w.getWorkoutMonth().equalsIgnoreCase(month)) {
                workoutsByYearMonth.add(w);
            }

        }
        return workoutsByYearMonth;
    }

    @Override
    public List<Workout> getWorkoutsByYearMonthWeek(List<Workout> workouts, int year, String month, Integer week) {

        List<Workout> workoutsByYearMonthWeek = new ArrayList<>();

        for (Workout w : workouts) {

            if (Integer.parseInt(w.getWorkoutDate().substring(6)) == year
                    && w.getWorkoutMonth().equalsIgnoreCase(month)
                    && w.getWeek() == week) {

                workoutsByYearMonthWeek.add(w);
//                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
//                Date date = null;
//
//                try {
//
//                    date = format.parse(w.getWorkoutDate());
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTime(date);
//                    int weekFromWorkout = cal.get(Calendar.WEEK_OF_MONTH);
//                    if (weekFromWorkout == week) workoutsByYearMonthWeek.add(w);
//
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
            }
        }
        return workoutsByYearMonthWeek;
    }

    @Override
    public Workout saveWorkout(Workout workout) {



        return null;
    }
}
