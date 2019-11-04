package com.bh.workouts.bhworkoutapp.controllers;

import com.bh.workouts.bhworkoutapp.services.AuthInitiatorService;
import com.bh.workouts.bhworkoutapp.services.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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

    public String getStats(Model model) {

        model.addAttribute("yearMap", statisticsService.getWorkoutsForYear(2019, authInitiatorService.getUserFromAuth()));

        return "/workout/stats";
    }


}