package com.my_baseball_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_baseball_site.service.RegisterService;

@Controller
public class RegisterController {
    @Autowired RegisterService rg_service;

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("today_register", rg_service.selectRegister());
        model.addAttribute("is_regist_or_out_register", rg_service.isRegistOrOutRegister());

        return "/register/register";
    }
}
