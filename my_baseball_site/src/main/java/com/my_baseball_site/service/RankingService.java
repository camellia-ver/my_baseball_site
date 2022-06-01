package com.my_baseball_site.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.my_baseball_site.mapper.RankingMapper;
import com.my_baseball_site.vo.RankingVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
    @Autowired RankingMapper mapper;

    public List<RankingVO> selectRankingToday(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(date);

        List<RankingVO> list = mapper.selectRankingByDate(today);

        SimpleDateFormat formatter2 = new SimpleDateFormat("MM월 dd일");
        String print_date;

        DecimalFormat n_formatter = new DecimalFormat("0.000");
        String print_win_rate;

        for(RankingVO item : list){
            print_date = formatter2.format(item.getR_date());
            item.setPrint_date(print_date);;

            print_win_rate = n_formatter.format(item.getWin_rate());
            item.setPrint_win_rate(print_win_rate);
        }

        return list;
    }

    public List<RankingVO> selectRankingByDate(String date){
        List<RankingVO> list = mapper.selectRankingByDate(date);

        SimpleDateFormat formatter2 = new SimpleDateFormat("MM월 dd일");
        String print_date;

        for(RankingVO item : list){
            print_date = formatter2.format(item.getR_date());
            item.setPrint_date(print_date);;
        }

        return list;
    }
}
