package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleGameResultAPIController {
    @GetMapping("/schedule_game_result/{date}")
    public Map<String,Object> getScheduleGameResultByDate(
        @PathVariable String date
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
    
        resultMap.put("status", true);
        resultMap.put("data", 1);

        return resultMap;
    }
}
