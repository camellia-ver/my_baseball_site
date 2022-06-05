package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.service.ScheduleGameResultService;
import com.my_baseball_site.vo.ScheduleGameResultVO;

@RestController
public class ScheduleGameResultAPIController {
    @Autowired ScheduleGameResultService sgr_service;

    @GetMapping("/schedule_game_result/{year}&{month}")
    public Map<String,Object> getScheduleGameResultByDate(
        @PathVariable String year,
        @PathVariable String month
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
    
        List<ScheduleGameResultVO> list = sgr_service.selectScheduleGameResultByYearMonth(year,month);

        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
}
