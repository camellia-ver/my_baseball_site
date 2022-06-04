package com.my_baseball_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleGameResultController {
    @GetMapping("/schedule_game_result")
    public String getScheduleGameResultController(Model model){
        return "schedule_game_result/schedule_game_result";
    }
}
