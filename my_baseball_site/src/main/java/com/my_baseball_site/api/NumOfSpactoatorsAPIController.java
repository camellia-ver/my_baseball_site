package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.mapper.NumOfSpactoatorsMapper;
import com.my_baseball_site.service.NumOfSpactoatorsService;
import com.my_baseball_site.vo.NumOfSpactoatorsByYearVO;
import com.my_baseball_site.vo.NumOfSpactoatorsVO;

@RestController
public class NumOfSpactoatorsAPIController {
    @Autowired NumOfSpactoatorsService nos_service;
    @Autowired NumOfSpactoatorsMapper nos_mapper;

    @GetMapping("/num_of_spactoators/api/list")
    public Map<String,Object> getNumOfSpactoators(
        @RequestParam String year,
        @RequestParam @Nullable String month,
        @RequestParam @Nullable String home_away,
        @RequestParam @Nullable String stadium,
        @RequestParam @Nullable String day_of_week
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        
        List<NumOfSpactoatorsVO> list = nos_service.selectNumOfSpactoators(year, month, home_away, stadium,day_of_week);

        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }

    @GetMapping("/num_of_spactoators/api/year/{selectData}")
    public Map<String,Object> getNumOfSpactoatorsByYear(
        @PathVariable String selectData
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        List<NumOfSpactoatorsByYearVO> list = null;

        if(selectData.equals("sum_year"))
            list = nos_mapper.selectSumYear();
        else
            list = nos_mapper.selectAvgOneGame();
        
        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
}
