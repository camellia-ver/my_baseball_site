package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.my_baseball_site.service.RankingService;
import com.my_baseball_site.vo.RankingVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankingAPIController {
    @Autowired RankingService r_service;

    @GetMapping("/ranking/api/{date}")
    public Map<String, Object> getRankingByDate(
        @PathVariable String date
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        
        List<RankingVO> list = r_service.selectRanking(date);

        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }

    @GetMapping("/ranking/api/graph")
    public Map<String,Object> getRankingGraph(
        @RequestParam String year_or_daily,
        @RequestParam @Nullable String start_date,
        @RequestParam @Nullable String end_date
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        
        List<RankingVO> list = null;
    
        if(year_or_daily.equals("일자")){
            list = r_service.selectRankingGraphByDay(start_date,end_date);
        }
        else{
            list = r_service.selectRankingGraphByYear();
        }

        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
}
