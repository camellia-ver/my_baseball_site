package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_baseball_site.mapper.PlayerDataMapper;

@Controller
public class PlayerListController {
    @Autowired PlayerDataMapper mapper;

    @GetMapping("/player_list")
    public String getPlayerList(Model model){
        model.addAttribute("list", mapper.selectPlayerDataByPosition("전체"));

        return "/player_data/player_list";
    }
}
