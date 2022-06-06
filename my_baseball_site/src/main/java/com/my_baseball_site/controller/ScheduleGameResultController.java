package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_baseball_site.mapper.ScheduleGameResultMapper;
import com.my_baseball_site.service.ScheduleGameResultService;

@Controller
public class ScheduleGameResultController {
    @Autowired ScheduleGameResultMapper sgr_mapper;
    @Autowired ScheduleGameResultService sgr_service;

    @GetMapping("/schedule_game_result")
    public String getScheduleGameResultController(Model model){
        model.addAttribute("years", sgr_mapper.selectYear());
        model.addAttribute("cur_data", sgr_service.selectScheduleGameResultCurrent());

        return "/schedule_game_result/schedule_game_result";
    }
}
