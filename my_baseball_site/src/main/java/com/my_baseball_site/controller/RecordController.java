package com.my_baseball_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordController {
    @GetMapping("/baseball_word")
    public String getBaseBallWord(){
        return "/record/baseball_word";
    }

    @GetMapping("/team_hitter_record")
    public String getTeamHitterRecord(){
        return "/record/team_hitter_record";
    }

    @GetMapping("/team_pitcher_record")
    public String getTeamPitcherRecord(){
        return "/record/team_pitcher_record";
    }

    @GetMapping("/team_defense_record")
    public String getTeamDefenseRecord(){
        return "/record/team_defense_record";
    }

    @GetMapping("/team_runner_record")
    public String getTeamRunnerRecord(){
        return "/record/team_runner_record";
    }
}
