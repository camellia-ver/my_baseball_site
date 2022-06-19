package com.my_baseball_site.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_baseball_site.mapper.RegisterMapper;
import com.my_baseball_site.vo.RegisterVO;

@Service
public class RegisterService {
    @Autowired RegisterMapper rg_mapper;

    public List<RegisterVO> todaySelectRegister(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(now.getTime());
        SimpleDateFormat printFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy년 MM월 dd일");

        List<RegisterVO> list = rg_mapper.selectRegister(today);

        if(list.size() == 0){
            now.add(Calendar.DATE,-1);
            today = formatter.format(now.getTime());
            list = rg_mapper.selectRegister(today);
        }
        
        for(RegisterVO item:list){
            item.setPrint_date(dateFormatter.format(now.getTime()));
            item.setPrint_brith(printFormatter.format(item.getRg_brith()));
            item.setMax_date(printFormatter.format(item.getRg_date()));
        }

        return list;
    }
    
    public List<RegisterVO> selectRegisterByDate(String date){
        SimpleDateFormat printFormatter = new SimpleDateFormat("yyyy-MM-dd");

        List<RegisterVO> list = rg_mapper.selectRegister(date);

        for(RegisterVO item:list){
            item.setPrint_brith(printFormatter.format(item.getRg_brith()));
        }

        return list;
    }

    public List<Integer> isRegistOrOutRegister(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(now.getTime());

        List<Integer> list = rg_mapper.isRegistOrOutRegister(today);
        
        return list;
    }
}
