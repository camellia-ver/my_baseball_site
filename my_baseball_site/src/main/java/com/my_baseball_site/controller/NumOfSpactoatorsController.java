package com.my_baseball_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumOfSpactoatorsController {
    @GetMapping("/num_of_spactoators")
    public String getNumOfSpactoators(Model model){
        return "/num_of_spactoators/num_of_spactoators";
    }
}
