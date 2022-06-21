package com.my_baseball_site.controller;

import com.my_baseball_site.mapper.RankingMapper;
import com.my_baseball_site.service.RankingService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        model.addAttribute("today_ranking", r_service.selectRanking());
        model.addAttribute("years", r_mapper.selectYear());
        model.addAttribute("startDate", r_service.selectStartDate());
        return "/ranking/ranking";
    }

    @GetMapping("/ranking/graph")
    public String getRankingGraph(Model model){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar date = Calendar.getInstance();

        String end_date = formatter.format(date.getTime());
        date.add(Calendar.DATE,-30);
        String start_date = formatter.format(date.getTime());
        
        model.addAttribute("start_date",start_date);
        model.addAttribute("end_date", end_date);

        return "/ranking/ranking_graph";
    }
}
