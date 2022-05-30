package com.my_baseball_site.controller;

import com.my_baseball_site.mapper.RankingMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCotroller {
    @Autowired RankingMapper r_mapper;

    @GetMapping("/")
    public String getMain(Model model){
        model.addAttribute("today_ranking", r_mapper.selectRankingToday());

        return "/main";
    }
}
