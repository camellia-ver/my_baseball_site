package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.mapper.PlayerDataMapper;
import com.my_baseball_site.vo.PlayerDataVO;

@RestController
public class PlayerDataAPIController {
    @Autowired PlayerDataMapper mapper;

    @GetMapping("/player_data_by_position/api/{position}")
    public Map<String, Object> getPlayerDataByPosition(
        @PathVariable String position
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        
        List<PlayerDataVO> list = mapper.selectPlayerDataByPosition(position);

        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }

    @GetMapping("/player_data_by_name/api/{name}")
    public Map<String, Object> getPlayerDataByName(
        @PathVariable String name
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        
        List<PlayerDataVO> list = mapper.selectPlayerDataByName(name);
        
        resultMap.put("status", true);
        resultMap.put("data", list);

        return resultMap;
    }
}
