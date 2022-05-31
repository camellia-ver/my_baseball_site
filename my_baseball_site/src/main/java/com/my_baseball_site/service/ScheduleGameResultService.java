package com.my_baseball_site.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.my_baseball_site.mapper.ScheduleGameResultMapper;
import com.my_baseball_site.vo.ScheduleGameResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleGameResultService {
    @Autowired ScheduleGameResultMapper sgr_mapper;

    public List<ScheduleGameResultVO> selectScheduleThreeGame(){
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE,-1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(date.getTime());

        List<ScheduleGameResultVO> list = sgr_mapper.selectScheduleThreeGame(today);

        for(ScheduleGameResultVO item : list){
            SimpleDateFormat formatter2 = new SimpleDateFormat("MM월 dd일");
            String print_date = formatter2.format(item.getG_date());
            item.setDate(print_date);
        }

        return list;
    }
}
