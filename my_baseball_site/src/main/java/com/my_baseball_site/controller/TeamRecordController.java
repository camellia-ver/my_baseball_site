package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_baseball_site.mapper.RecordMapper;
import com.my_baseball_site.service.TeamRecordService;

@Controller
public class TeamRecordController {
    @Autowired RecordMapper mapper;
    @Autowired TeamRecordService service;

    @GetMapping("/baseball_word")
    public String getBaseBallWord(){
        return "/record/baseball_word";
    }

    @GetMapping("/team_hitter_record")
    public String getTeamHitterRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());

        return "/record/team_hitter_record";
    }

    @GetMapping("/team_pitcher_record")
    public String getTeamPitcherRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());

        return "/record/team_pitcher_record";
    }

    @GetMapping("/team_defense_record")
    public String getTeamDefenseRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());
        model.addAttribute("defense", service.selectTeamDefenseRecord());

        return "/record/team_defense_record";
    }

    @GetMapping("/team_runner_record")
    public String getTeamRunnerRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());
        model.addAttribute("runner", service.selectTeamRunnerRecord());

        return "/record/team_runner_record";
    }
}
