package com.my_baseball_site.controller;

import com.my_baseball_site.mapper.RankingMapper;
import com.my_baseball_site.service.RankingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankingCotroller {
    @Autowired RankingService r_service;
    @Autowired RankingMapper r_mapper;

    @GetMapping("/ranking")
    public String getRanking(Model model){
        model.addAttribute("today_ranking", r_service.selectRankingToday());
        model.addAttribute("years", r_mapper.selectYear());

        return "ranking/ranking";
    }
}
