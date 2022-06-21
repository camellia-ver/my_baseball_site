package com.my_baseball_site.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my_baseball_site.service.RegisterService;
import com.my_baseball_site.vo.RegisterVO;

@RestController
public class RegisterAPIController {
    @Autowired RegisterService rg_service;

    @GetMapping("/register/api/{date}")
    public Map<String, Object> getRegisterByDate(
        @PathVariable String date
    ){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();

        List<RegisterVO> list = rg_service.selectRegister(date);

        resultMap.put("status", true);
        resultMap.put("data", list);
        
        return resultMap;
    }
}
