package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.models.WorkoutType;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentMonthDaysService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentWorkoutDaysByWeekService;
import com.bh.workouts.bhworkoutapp.services.helpers.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.helpers.stats.MonthWorkoutsStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Controller
public class CurrentMonthWorkoutViewController {

    private final WorkoutRepository workoutRepository;
    private final MonthWorkoutsStatsService workoutsStatsService;
    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public CurrentMonthWorkoutViewController(WorkoutRepository workoutRepository,
                                             MonthWorkoutsStatsService workoutsStatsService,
                                             AuthInitiatorService authInitiatorService) {
        this.workoutRepository = workoutRepository;
        this.workoutsStatsService = workoutsStatsService;
        this.authInitiatorService = authInitiatorService;
    }

    @RequestMapping("/workouts/month")
    public String getWorkoutsMonthView(Model model) {

        LocalDate localDate = LocalDate.now();

        List<Workout> workouts = workoutRepository.findAll();

        YearMonth yearMonth = YearMonth.now();

        int pecsWorkoutsNumber =
                workoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.PECS.name(), authInitiatorService.getUserFromAuth());
        int backWorkoutsNumber =
                workoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.BACK.name(), authInitiatorService.getUserFromAuth());
        int bicepsWorkoutsNumber =
                workoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.BICEPS.name(), authInitiatorService.getUserFromAuth());
        int tricepsWorkoutsNumber =
                workoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.TRICEPS.name(), authInitiatorService.getUserFromAuth());
        int deltsWorkoutsNumber =
                workoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.DELTS.name(), authInitiatorService.getUserFromAuth());

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

        model.addAttribute("userWorkouts", GetSpecificUserWorkoutsService.userWorkouts(workouts, authInitiatorService.getUserFromAuth()));
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
