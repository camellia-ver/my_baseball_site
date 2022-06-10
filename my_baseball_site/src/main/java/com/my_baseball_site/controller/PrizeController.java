package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_baseball_site.mapper.PrizeMapper;

@Controller
public class PrizeController {
    @Autowired PrizeMapper p_mapper;

    @GetMapping("/player_prize")
    public String getPlayerPrize(Model model){
        model.addAttribute("player_prize", p_mapper.selectPlayerPrize());

        return "/prize/player_prize";
    }

    @GetMapping("/golden_glove")
    public String getGoldenGlove(Model model){
        model.addAttribute("golden_glove", p_mapper.selectGoldenGlove());

        return "/prize/golden_glove";
    }
}
