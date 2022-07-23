package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my_baseball_site.mapper.PlayerDataMapper;
import com.my_baseball_site.service.PlayerDataService;
import com.my_baseball_site.vo.PlayerDataVO;

@Controller
public class PlayerDataDetail {
    @Autowired PlayerDataMapper mapper;
    @Autowired PlayerDataService service;

    @GetMapping("/detail")
    public String getDetail(
        @RequestParam String name,
        @RequestParam String birth,
        Model model
        ){
        PlayerDataVO data = mapper.selectPlayerProfile(name, birth);
        model.addAttribute("profile", data);

        if(data.getLeague().equals("1군")){
            if(data.getPosition1().equals("투수")){
                model.addAttribute("record", service.selectPitcherRecord(name, birth));
            }
            else{
                model.addAttribute("record", service.selectHitterRecord(name, birth));
            }
        }
        else{
            if(data.getPosition1().equals("투수")){
                model.addAttribute("record", service.selectFuturesPitcherRecord(name, birth));
            }
            else{
                model.addAttribute("record", service.selectFuturesHitterRecord(name, birth));
            }
        }

        return "/player_data/player_data_detail";
    }
}
