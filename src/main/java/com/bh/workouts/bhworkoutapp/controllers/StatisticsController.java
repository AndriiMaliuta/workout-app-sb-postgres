package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.services.helpers.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.helpers.stats.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    private final StatisticsService statisticsService;
    private final AuthInitiatorService authInitiatorService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService,
                                AuthInitiatorService authInitiatorService) {
        this.statisticsService = statisticsService;
        this.authInitiatorService = authInitiatorService;
    }

    @GetMapping("/workout/stats")
    public String getStats(Model model) {

        model.addAttribute("yearMap", statisticsService.getWorkoutsForYear(2019, authInitiatorService.getUserFromAuth()));
        model.addAttribute("year", 2019);

        return "workouts/stats";
    }


}