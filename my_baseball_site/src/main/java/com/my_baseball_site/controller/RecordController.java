package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_baseball_site.mapper.RecordMapper;
import com.my_baseball_site.service.RecordService;

@Controller
public class RecordController {
    @Autowired RecordMapper mapper;
    @Autowired RecordService service;

    @GetMapping("/baseball_word")
    public String getBaseBallWord(){
        return "/record/baseball_word";
    }

    @GetMapping("/team_hitter_record")
    public String getTeamHitterRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());
        model.addAttribute("hitter", service.selectTeamHitterRecord());

        return "/record/team/team_hitter_record";
    }

    @GetMapping("/team_pitcher_record")
    public String getTeamPitcherRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());
        model.addAttribute("pitcher", service.selectTeamPitcherRecord());

        return "/record/team/team_pitcher_record";
    }

    @GetMapping("/team_defense_record")
    public String getTeamDefenseRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());
        model.addAttribute("defense", service.selectTeamDefenseRecord());

        return "/record/team/team_defense_record";
    }

    @GetMapping("/team_runner_record")
    public String getTeamRunnerRecord(Model model){
        model.addAttribute("regular_serise_year", mapper.selectRegularSeriseYear());
        model.addAttribute("runner", service.selectTeamRunnerRecord());

        return "/record/team/team_runner_record";
    }

    @GetMapping("/player_hitter_record_detail")
    public String getPlayerHitterRecordDetail(){
        return "/record/player/player_hitter_record_detail";
    }
    @GetMapping("/player_hitter_record")
    public String getPlayerHitterRecord(){
        return "/record/player/player_hitter_record";
    }

    @GetMapping("/player_pitcher_record_detail")
    public String getPlayerPitcherRecordDetail(){
        return "/record/player/player_pitcher_record_detail";
    }
    @GetMapping("/player_pitcher_record")
    public String getPlayerPitcherRecord(){
        return "/record/player/player_pitcher_record";
    }

    @GetMapping("/player_defense_record")
    public String getPlayerDefenseRecord(){
        return "/record/player/player_defense_record";
    }

    @GetMapping("/player_runner_record")
    public String getPlayerRunnerRecord(){
        return "/record/player/player_runner_record";
    }
}
