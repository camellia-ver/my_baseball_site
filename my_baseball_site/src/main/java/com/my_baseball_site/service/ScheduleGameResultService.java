package com.my_baseball_site.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.my_baseball_site.mapper.ScheduleGameResultMapper;
import com.my_baseball_site.vo.ScheduleGameResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleGameResultService {
    @Autowired ScheduleGameResultMapper sgr_mapper;

    public List<ScheduleGameResultVO> selectScheduleThreeGame(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(date);

        List<ScheduleGameResultVO> list = sgr_mapper.selectScheduleThreeGame(today);

        for(ScheduleGameResultVO item : list){
            SimpleDateFormat formatter2 = new SimpleDateFormat("MM월 dd일");
            String print_date = formatter2.format(item.getG_date());
            item.setDate(print_date);
        }

        return list;
    }

    public ScheduleGameResultVO selectRecentlyGameResult(){   
        Calendar date = Calendar.getInstance();
        Integer cur_year = date.getWeekYear();
        date.add(Calendar.DATE,-1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(date.getTime());

        while(true){
            if(sgr_mapper.isGame(today) == 1){
                break;
            }
            else{
                date.add(Calendar.DATE,-1);
                today = formatter.format(date.getTime());
            }

            if(date.getWeekYear() != cur_year){
                ScheduleGameResultVO data = null;

                return data;
            }
        }

        ScheduleGameResultVO data = sgr_mapper.selectRecentlyGameResult(today);
        SimpleDateFormat formatter2 = new SimpleDateFormat("MM월 dd일");
        String print_date;

        if(!data.getNote().equals("-")){
            print_date = formatter2.format(data.getG_date());
            data.setDate(print_date);

            return data;
        }
        else if(data.getTeam1_score() > data.getTeam2_score()){
            if(data.getTeam1().equals("삼성"))
                data.setResult("승리");
            else
                data.setResult("패배");
        }
        else if(data.getTeam1_score() < data.getTeam2_score()){
            if(data.getTeam2().equals("삼성"))
                data.setResult("승리");
            else
                data.setResult("패배");
        }
        else{
            data.setResult("무승부");
        }

        print_date = formatter2.format(data.getG_date());
        data.setDate(print_date);

        return data;
    }
}
