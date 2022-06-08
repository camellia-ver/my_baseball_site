package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.service.ScheduleGameResultService;
import com.my_baseball_site.vo.ScheduleGameResultVO;

@RestController
public class ScheduleGameResultAPIController {
    @Autowired ScheduleGameResultService sgr_service;

    @GetMapping("/schedule_game_result/api/list")
    public Map<String,Object> getScheduleGameResultByDate(
        @RequestParam String year,
        @RequestParam @Nullable String month,
        @RequestParam String season
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
    
        List<ScheduleGameResultVO> list = sgr_service.selectScheduleGameResultByYearMonth(year,month,season);
        
        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
}
