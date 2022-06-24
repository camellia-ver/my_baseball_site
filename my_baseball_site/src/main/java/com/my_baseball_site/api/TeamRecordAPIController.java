package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.mapper.RecordMapper;
import com.my_baseball_site.service.RecordService;
import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamHitterRecordVO;
import com.my_baseball_site.vo.TeamPitcherRecordVO;
import com.my_baseball_site.vo.TeamRunnerRecordVO;

@RestController
public class TeamRecordAPIController {
    @Autowired RecordService service;
    @Autowired RecordMapper mapper;

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

        List<TeamRunnerRecordVO> list = mapper.selectTeamRunnerRecord(year);

        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }

    @GetMapping("/team_hitter_record/api/list")
    public Map<String, Object> getTeamHitterRecord(
        @RequestParam String year,
        @RequestParam String series
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<TeamHitterRecordVO> list = service.selectTeamHitterRecord(year, series);
        
        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }

    @GetMapping("/team_pitcher_record/api/list")
    public Map<String, Object> getTeamPitcherRecord(
        @RequestParam String year,
        @RequestParam String series
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<TeamPitcherRecordVO> list = service.selectTeamPitcherRecord(year, series);
        
        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }
}
