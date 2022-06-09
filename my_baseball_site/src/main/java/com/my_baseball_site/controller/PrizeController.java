package com.my_baseball_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrizeController {
    @GetMapping("/player_prize")
    public String getPlayerPrize(){
        return "/prize/player_prize";
    }

    @GetMapping("/golden_glove")
    public String getGoldenGlove(){
        return "/prize/golden_glove";
    }
}
