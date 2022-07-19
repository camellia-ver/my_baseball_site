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
import com.my_baseball_site.vo.PlayerDefensRecordVO;
import com.my_baseball_site.vo.PlayerHitterRecordBasicVO;
import com.my_baseball_site.vo.PlayerHitterRecordDetailVO;
import com.my_baseball_site.vo.PlayerPitcherRecordBasicVO;
import com.my_baseball_site.vo.PlayerPitcherRecordDetailVO;
import com.my_baseball_site.vo.PlayerRunnerRecordVO;
import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamHitterRecordVO;
import com.my_baseball_site.vo.TeamPitcherRecordVO;
import com.my_baseball_site.vo.TeamRunnerRecordVO;

@RestController
public class RecordAPIController {
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

        List<TeamRunnerRecordVO> list = service.selectTeamRunnerRecord(year);

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

    @GetMapping("/player_defense_record/api/list")
    public Map<String, Object> getPlayerDefenseRecord(
        @RequestParam String year,
        @RequestParam String position
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<PlayerDefensRecordVO> list = service.selectPlayerDefenseRecord(year, position);
        
        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }

    @GetMapping("/player_runner_record/api/list")
    public Map<String, Object> getPlayerRunnerRecord(
        @RequestParam String year,
        @RequestParam String position
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<PlayerRunnerRecordVO> list = service.selectPlayerRunnerRecord(year, position);
        
        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }

    @GetMapping("/player_hitter_record/api/basic")
    public Map<String, Object> getPlayerHitterRecordBasic(
        @RequestParam String year,
        @RequestParam String series,
        @RequestParam String position
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<PlayerHitterRecordBasicVO> list = service.selectPlayerHitterRecordBasic(year, series, position);

        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }
    @GetMapping("/player_hitter_record/api/detail")
    public Map<String, Object> getPlayerHitterRecordDetail(
        @RequestParam String year,
        @RequestParam String position
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<PlayerHitterRecordDetailVO> list = service.selectPlayerHitterRecordDetail(year, position);
        
        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }

    @GetMapping("/player_pitcher_record/api/basic")
    public Map<String, Object> getPlayerPitcherRecordBasic(
        @RequestParam String year,
        @RequestParam String series
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<PlayerPitcherRecordBasicVO> list = service.selectPlayerPitcherRecordBasic(year, series);
        
        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }
    @GetMapping("/player_pitcher_record/api/detail")
    public Map<String, Object> getPlayerPitcherRecordDetail(
        @RequestParam String year
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<PlayerPitcherRecordDetailVO> list = service.selectPlayerPitcherRecordDetail(year);
        
        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }
}
