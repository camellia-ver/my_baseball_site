package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_baseball_site.mapper.NumOfSpactoatorsMapper;
import com.my_baseball_site.service.NumOfSpactoatorsService;

@Controller
public class NumOfSpactoatorsController {
    @Autowired NumOfSpactoatorsService nos_service;
    @Autowired NumOfSpactoatorsMapper nos_mapper;

    @GetMapping("/num_of_spactoators")
    public String getNumOfSpactoators(Model model){
        model.addAttribute("num_of_spactoators",nos_service.selectNumOfSpactoatorsByCurMonth());
        model.addAttribute("years", nos_mapper.selectYear());
        model.addAttribute("baseball_stadiums", nos_mapper.selectBaseballStadium());

        return "/num_of_spactoators/num_of_spactoators";
    }

    @GetMapping("/num_of_spactoators/graph")
    public String getNumOfSpactoatorsGraph(){
        return "/num_of_spactoators/num_of_spactoators_graph";
    }
}
