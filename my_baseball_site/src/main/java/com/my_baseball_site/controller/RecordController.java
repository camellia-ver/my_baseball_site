package com.my_baseball_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordController {
    @GetMapping("/baseball_word")
    public String getBaseBallWord(){
        return "/record/baseball_word";
    }
}
