package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.User;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.models.WorkoutType;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.UserService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentMonthDaysService;
import com.bh.workouts.bhworkoutapp.services.stats.MonthWorkoutsStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Controller
public class CurrentMonthWorkoutViewController {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;

    @Autowired
    public CurrentMonthWorkoutViewController(WorkoutRepository workoutRepository,
                                             UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @RequestMapping("/workouts/month")
    public String getWorkoutsMonthView(Model model) {

        LocalDate localDate = LocalDate.now();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByLogin = userService.findUserByLogin(authentication.getName());

        List<Workout> workouts = workoutRepository.findAll();

        YearMonth yearMonth = YearMonth.now();

        MonthWorkoutsStatsService monthWorkoutsStatsService = new MonthWorkoutsStatsService(workoutRepository);

        int pecsWorkoutsNumber = monthWorkoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.PECS.name(), userByLogin);
        int backWorkoutsNumber = monthWorkoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.BACK.name(), userByLogin);
        int bicepsWorkoutsNumber = monthWorkoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.BICEPS.name(), userByLogin);
        int tricepsWorkoutsNumber = monthWorkoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.TRICEPS.name(), userByLogin);
        int deltsWorkoutsNumber = monthWorkoutsStatsService.getWorkoutsNumberByType(localDate.getMonth().name(), WorkoutType.DELTS.name(), userByLogin);

        model.addAttribute("userWorkouts", GetSpecificUserWorkoutsService.userWorkouts(workouts, userByLogin));
        model.addAttribute("currentDayMap", CurrentMonthDaysService.getMonthDays(yearMonth));
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
