package com.my_baseball_site.controller;

import com.my_baseball_site.service.RankingService;
import com.my_baseball_site.service.ScheduleGameResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCotroller {
    @Autowired RankingService r_service;
    @Autowired ScheduleGameResultService sgr_service;

    @GetMapping("/")
    public String getMain(Model model){
        model.addAttribute("today_ranking", r_service.selectRanking());
        model.addAttribute("three_game_schedule", sgr_service.selectScheduleThreeGame());
        model.addAttribute("recently_game", sgr_service.selectRecentlyGameResult());

        return "/main";
    }
}
