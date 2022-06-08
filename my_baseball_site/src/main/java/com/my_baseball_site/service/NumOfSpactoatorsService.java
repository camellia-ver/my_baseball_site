package com.my_baseball_site.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_baseball_site.mapper.NumOfSpactoatorsMapper;
import com.my_baseball_site.vo.NumOfSpactoatorsVO;

@Service
public class NumOfSpactoatorsService {
    @Autowired NumOfSpactoatorsMapper mapper;

    public List<NumOfSpactoatorsVO> selectNumOfSpactoatorsByCurYear(){
        Date date = new Date();
        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy"); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DecimalFormat n_formatter = new DecimalFormat("#,###");

        String curYear = yearFormatter.format(date);
        String printDate;
        String print_spactoators;
        
        List<NumOfSpactoatorsVO> list = mapper.selectNumOfSpactoators(curYear, null,null,null,null);

        for(NumOfSpactoatorsVO item:list){
            printDate = dateFormat.format(item.getNos_date());
            item.setDate(printDate);

            item.setCur_year(curYear);

            print_spactoators = n_formatter.format(item.getSpactoators());
            item.setPrint_spactoators(print_spactoators);
        }

        return list;
    }

    public List<NumOfSpactoatorsVO> selectNumOfSpactoators(
        String year,String month,String home_away,
        String stadium,String day_of_week
    ){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DecimalFormat n_formatter = new DecimalFormat("#,###");

        String printDate;
        String print_spactoators;
        
        if(month.equals("")) month = null;
        if(home_away.equals("")) home_away = null;
        if(stadium.equals("")) stadium = null;
        if(day_of_week.equals("")) day_of_week = null;
        
        List<NumOfSpactoatorsVO> list = mapper.selectNumOfSpactoators(year, month,home_away,stadium,day_of_week);
        
        for(NumOfSpactoatorsVO item:list){
            printDate = dateFormat.format(item.getNos_date());
            item.setDate(printDate);

            print_spactoators = n_formatter.format(item.getSpactoators());
            item.setPrint_spactoators(print_spactoators);
        }

        return list;
    }
}
