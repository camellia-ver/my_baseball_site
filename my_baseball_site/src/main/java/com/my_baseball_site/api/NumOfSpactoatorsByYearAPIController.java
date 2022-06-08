package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.mapper.NumOfSpactoatorsByYearMapper;
import com.my_baseball_site.vo.NumOfSpactoatorsByYearVO;

@RestController
public class NumOfSpactoatorsByYearAPIController {
    @Autowired NumOfSpactoatorsByYearMapper nosby_mapper;

    @GetMapping("/num_of_spactoators/year/api/{selectData}")
    public Map<String,Object> getNumOfSpactoatorsByYear(
        @PathVariable String selectData
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        List<NumOfSpactoatorsByYearVO> list = null;

        if(selectData.equals("sum_year"))
            list = nosby_mapper.selectSumYear();
        else
            list = nosby_mapper.selectAvgOneGame();
        
        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
}
