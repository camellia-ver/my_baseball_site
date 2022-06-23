package com.my_baseball_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerRecordController {
    @GetMapping("/player_hitter_record")
    public String getPlayerHitterRecord(){
        return "/record/player_hitter_record";
    }

    @GetMapping("/player_pitcher_record")
    public String getPlayerPitcherRecord(){
        return "/record/player_pitcher_record";
    }

    @GetMapping("/player_defense_record")
    public String getPlayerDefenseRecord(){
        return "/record/player_defense_record";
    }

    @GetMapping("/player_runner_record")
    public String getPlayerRunnerRecord(){
        return "/record/player_runner_record";
    }
}
