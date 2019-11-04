package com.bh.workouts.bhworkoutapp.controllers.workout;

import com.bh.workouts.bhworkoutapp.models.MonthForm;
import com.bh.workouts.bhworkoutapp.models.Workout;
import com.bh.workouts.bhworkoutapp.models.WorkoutType;
import com.bh.workouts.bhworkoutapp.repositories.WorkoutRepository;
import com.bh.workouts.bhworkoutapp.services.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentMonthDaysService;
import com.bh.workouts.bhworkoutapp.services.dates.CurrentWorkoutDaysByWeekService;
import com.bh.workouts.bhworkoutapp.services.helpers.DigitFromMonthNameService;
import com.bh.workouts.bhworkoutapp.services.helpers.GetSpecificUserWorkoutsService;
import com.bh.workouts.bhworkoutapp.services.helpers.stats.MonthWorkoutsStatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OtherMonthWorkoutController {

    private final WorkoutRepository workoutRepository;
    private final AuthInitiatorService authInitiatorService;
    private final MonthWorkoutsStatsService monthWorkoutsStatsService;

    private Logger logger = LoggerFactory.getLogger(OtherMonthWorkoutController.class);

    @Autowired
    public OtherMonthWorkoutController(WorkoutRepository workoutRepository,
                                       AuthInitiatorService authInitiatorService,
                                       MonthWorkoutsStatsService monthWorkoutsStatsService) {
        this.workoutRepository = workoutRepository;
        this.authInitiatorService = authInitiatorService;
        this.monthWorkoutsStatsService = monthWorkoutsStatsService;
    }

    @GetMapping("/workout/other/month")
    public String getOtherMonthForm(Model model) {

        List<String> months = new ArrayList<>();

        months.add("JANUARY");
        months.add("FEBRUARY");
        months.add("MARCH");
        months.add("APRIL");
        months.add("MAY");
        months.add("JUNE");
        months.add("JULY");
        months.add("AUGUST");
        months.add("SEPTEMBER");
        months.add("OCTOBER");
        months.add("NOVEMBER");
        months.add("DECEMBER");

        model.addAttribute("months", months);
        model.addAttribute("monthForm", new MonthForm());

        return "workouts/other-month-form";
    }

    @PostMapping("/workout/other/month")
    public String getOtherMonthPage(@ModelAttribute MonthForm monthForm, Model model) {

        List<Workout> workouts = workoutRepository.findAll();

        String monthName = monthForm.getMonth();

        YearMonth yearMonth;

        try {

            if (monthForm.getYear() == 0 || monthForm.getYear() == null) {
                yearMonth = YearMonth.of(Year.now().getValue(), DigitFromMonthNameService.getDigitFromMonth(monthName));
            } else {
                yearMonth = YearMonth.of(monthForm.getYear(), DigitFromMonthNameService.getDigitFromMonth(monthName));
            }

            int pecsWorkoutsNumber =
                    monthWorkoutsStatsService.getWorkoutsNumberByType(monthName, WorkoutType.PECS.name(), authInitiatorService.getUserFromAuth());
            int backWorkoutsNumber =
                    monthWorkoutsStatsService.getWorkoutsNumberByType(monthName, WorkoutType.BACK.name(), authInitiatorService.getUserFromAuth());
            int bicepsWorkoutsNumber =
                    monthWorkoutsStatsService.getWorkoutsNumberByType(monthName, WorkoutType.BICEPS.name(), authInitiatorService.getUserFromAuth());
            int tricepsWorkoutsNumber =
                    monthWorkoutsStatsService.getWorkoutsNumberByType(monthName, WorkoutType.TRICEPS.name(), authInitiatorService.getUserFromAuth());
            int deltsWorkoutsNumber =
                    monthWorkoutsStatsService.getWorkoutsNumberByType(monthName, WorkoutType.DELTS.name(), authInitiatorService.getUserFromAuth());

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
            model.addAttribute("currentDayMap", CurrentMonthDaysService.getMonthDays(yearMonth));
            model.addAttribute("pecsWorkoutsNumber", pecsWorkoutsNumber);
            model.addAttribute("bicepsWorkoutsNumber", bicepsWorkoutsNumber);
            model.addAttribute("tricepsWorkoutsNumber", tricepsWorkoutsNumber);
            model.addAttribute("backWorkoutsNumber", backWorkoutsNumber);
            model.addAttribute("deltsWorkoutsNumber", deltsWorkoutsNumber);

            model.addAttribute("userWorkouts", GetSpecificUserWorkoutsService.userWorkouts(workouts, authInitiatorService.getUserFromAuth()));
//            model.addAttribute("currentDayMap", CurrentMonthDaysService.getMonthDays(yearMonth));
            model.addAttribute("monthName", monthName);
            model.addAttribute("yearMonth", monthForm.getYear());

        } catch (NullPointerException e) {
            logger.info(e.toString());
        }

        logger.info("=========== Other month page initiated for: " + monthName +" " + DigitFromMonthNameService.getDigitFromMonth(monthName));

        return "workouts/workouts-other-month-table";
    }
}
