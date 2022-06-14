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
        date.add(Calendar.DATE,-1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(date.getTime());
        
        ScheduleGameResultVO data = sgr_mapper.selectRecentlyGameResult(today);
        SimpleDateFormat formatter2 = new SimpleDateFormat("MM월 dd일");
        String print_date;

        if(data == null){
            return null;
        }

        print_date = formatter2.format(data.getG_date());
        data.setDate(print_date);

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
        
        return data;
    }

    public List<ScheduleGameResultVO> selectScheduleGameResultCurrent(){
        Date now = new Date();
        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
        String year = yearFormatter.format(now);

        SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");
        String month = monthFormatter.format(now);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");

        List<ScheduleGameResultVO> list = sgr_mapper.selectScheduleGameResultByYearMonthSeason(year, month,"정규시즌");

        for(ScheduleGameResultVO item : list){
            item.setDate(dateFormat.format(item.getG_date()));
        }

        return list;
    }

    public List<ScheduleGameResultVO> selectScheduleGameResultByYearMonth(String year,String month,String season){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");

        if(month.equals("")) month = null;

        List<ScheduleGameResultVO> list = sgr_mapper.selectScheduleGameResultByYearMonthSeason(year, month,season);

        for(ScheduleGameResultVO item : list){
            item.setDate(dateFormat.format(item.getG_date()));
        }

        return list;
    }
}
