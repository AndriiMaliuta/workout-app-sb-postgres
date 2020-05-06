package com.bh.workouts.bhworkoutapp.thyme.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.models.WorkoutType;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentMonthDaysService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentWorkoutDaysByWeekService;
import com.bh.workouts.bhworkoutapp.services.helpers.stats.StatisticsService;
import com.bh.workouts.bhworkoutapp.services.workout.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.List;

@Controller
public class CurrentMonthWorkoutViewController {

    private final WorkoutRepository workoutRepository;
    private final StatisticsService statisticsService;
    private final AuthInitiatorService authInitiatorService;
    private final WorkoutService workoutService;

    @Autowired
    public CurrentMonthWorkoutViewController(WorkoutRepository workoutRepository,
                                             StatisticsService statisticsService,
                                             AuthInitiatorService authInitiatorService,
                                             WorkoutService workoutService) {
        this.workoutRepository = workoutRepository;
        this.statisticsService = statisticsService;
        this.authInitiatorService = authInitiatorService;
        this.workoutService = workoutService;
    }

    @RequestMapping("/workouts/month")
    public String getWorkoutsMonthView(Model model) {

        LocalDate localDate = LocalDate.now();

        List<Workout> workouts = workoutRepository.findAll();

        YearMonth yearMonth = YearMonth.now();

        int pecsWorkoutsNumber =
                statisticsService.getWorkoutsNumberByType(
                        Calendar.getInstance().get(Calendar.YEAR),
                        localDate.getMonth().name(),
                        WorkoutType.PECS.name(),
                        authInitiatorService.getUserFromAuth());
        int backWorkoutsNumber =
                statisticsService.getWorkoutsNumberByType(
                        Year.now().getValue(),
                        localDate.getMonth().name(), WorkoutType.BACK.name(), authInitiatorService.getUserFromAuth());
        int bicepsWorkoutsNumber =
                statisticsService.getWorkoutsNumberByType(
                        LocalDate.now().getYear(),
                        localDate.getMonth().name(), WorkoutType.BICEPS.name(), authInitiatorService.getUserFromAuth());
        int tricepsWorkoutsNumber =
                statisticsService.getWorkoutsNumberByType(
                        Calendar.getInstance().get(Calendar.YEAR),
                        localDate.getMonth().name(), WorkoutType.TRICEPS.name(), authInitiatorService.getUserFromAuth());
        int deltsWorkoutsNumber =
                statisticsService.getWorkoutsNumberByType(
                        Calendar.getInstance().get(Calendar.YEAR),
                        localDate.getMonth().name(), WorkoutType.DELTS.name(), authInitiatorService.getUserFromAuth());

        model.addAttribute("weekOneCurrentDays",
                CurrentWorkoutDaysByWeekService.getCurrentWorkoutDaysByWeek(CurrentMonthDaysService.getMonthDays(yearMonth), 1));
        model.addAttribute("weekTwoCurrentDays",
                CurrentWorkoutDaysByWeekService.getCurrentWorkoutDaysByWeek(CurrentMonthDaysService.getMonthDays(yearMonth), 2));
        model.addAttribute("weekThreeCurrentDays",
                CurrentWorkoutDaysByWeekService.getCurrentWorkoutDaysByWeek(CurrentMonthDaysService.getMonthDays(yearMonth), 3));
        model.addAttribute("weekFourCurrentDays",
                CurrentWorkoutDaysByWeekService.getCurrentWorkoutDaysByWeek(CurrentMonthDaysService.getMonthDays(yearMonth), 4));
        model.addAttribute("weekFiveCurrentDays",
                CurrentWorkoutDaysByWeekService.getCurrentWorkoutDaysByWeek(CurrentMonthDaysService.getMonthDays(yearMonth), 5));
        model.addAttribute("weekSixCurrentDays",
                CurrentWorkoutDaysByWeekService.getCurrentWorkoutDaysByWeek(CurrentMonthDaysService.getMonthDays(yearMonth), 6));

        model.addAttribute("userWorkouts", workoutService.userWorkouts(workouts, authInitiatorService.getUserFromAuth()));
//        model.addAttribute("currentDayMap", CurrentMonthDaysService.getMonthDays(yearMonth));
        model.addAttribute("pecsWorkoutsNumber", pecsWorkoutsNumber);
        model.addAttribute("bicepsWorkoutsNumber", bicepsWorkoutsNumber);
        model.addAttribute("tricepsWorkoutsNumber", tricepsWorkoutsNumber);
        model.addAttribute("backWorkoutsNumber", backWorkoutsNumber);
        model.addAttribute("deltsWorkoutsNumber", deltsWorkoutsNumber);
        model.addAttribute("monthNow", localDate.getMonth().name());
        model.addAttribute("yearNow", localDate.getYear());

        return "workouts/workouts-month-table";
    }

}
