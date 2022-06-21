package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.service.TeamRecordService;
import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamRunnerRecordVO;

@RestController
public class TeamRecordAPIController {
    @Autowired TeamRecordService service;

    @GetMapping("/team_defense_record/api/{year}")
    public Map<String, Object> getTeamDefenseRecord(
        @PathVariable String year
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<TeamDefenseRecordVO> list = service.selectTeamDefenseRecord(year);

        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }

    @GetMapping("/team_runner_record/api/{year}")
    public Map<String, Object> getTeamRunnerRecord(
        @PathVariable String year
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<TeamRunnerRecordVO> list = service.selectTeamRunnerRecord(year);

        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }
}
