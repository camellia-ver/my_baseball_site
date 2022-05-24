package com.my_baseball_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCotroller {
    @GetMapping("/")
    public String getMain(){
        return "/index";
    }
}
