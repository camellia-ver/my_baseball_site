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

        SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
        String max_date;

        SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy년 MM월 dd일");
        String print_full_date;

        DecimalFormat n_formatter = new DecimalFormat("0.000");
        String print_win_rate;

        DecimalFormat n_formatter2 = new DecimalFormat("0.#");
        String print_game_difference;

        for(RankingVO item : list){
            print_date = formatter2.format(item.getR_date());
            item.setPrint_date(print_date);

            max_date = formatter3.format(item.getR_date());
            item.setMax_date(max_date);

            print_full_date = formatter4.format(item.getR_date());
            item.setPrint_full_date(print_full_date);

            print_win_rate = n_formatter.format(item.getWin_rate());
            item.setPrint_win_rate(print_win_rate);

            print_game_difference = n_formatter2.format(item.getGame_difference());
            item.setPrint_game_difference(print_game_difference);
        }

        if(list.size() == 0){
            Date year = new Date();
            SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
            String cur_year = yearFormatter.format(year);
            cur_year += "1231";

            list = mapper.selectRankingByDate(cur_year);

            for(RankingVO item : list){
                print_date = formatter2.format(item.getR_date());
                item.setPrint_date(print_date);;
    
                max_date = formatter3.format(item.getR_date());
                item.setMax_date(max_date);
    
                print_full_date = formatter4.format(item.getR_date());
                item.setPrint_full_date(print_full_date);

                print_win_rate = n_formatter.format(item.getWin_rate());
                item.setPrint_win_rate(print_win_rate);
    
                print_game_difference = n_formatter2.format(item.getGame_difference());
                item.setPrint_game_difference(print_game_difference);
            }

            return list;
        }

        return list;
    }

    public String selectStartDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(date) + "0101";

        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date = mapper.selectStartDate(cur_year);
        String min_date = formatter2.format(start_date);

        return min_date;
    }

    public List<RankingVO> selectRankingByDate(String date){
        List<RankingVO> list = mapper.selectRankingByDate(date);

        SimpleDateFormat formatter2 = new SimpleDateFormat("MM월 dd일");
        String print_date;

        SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy년 MM월 dd일");
        String print_full_date;

        DecimalFormat n_formatter = new DecimalFormat("0.000");
        String print_win_rate;

        DecimalFormat n_formatter2 = new DecimalFormat("0.#");
        String print_game_difference;

        if(list.size() == 0){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            String cur_year = formatter.format(date);

            cur_year += "1231";

            list = mapper.selectRankingByDate(cur_year);

            for(RankingVO item : list){
                print_date = formatter2.format(item.getR_date());
                item.setPrint_date(print_date);

                print_full_date = formatter4.format(item.getR_date());
                item.setPrint_full_date(print_full_date);


                print_win_rate = n_formatter.format(item.getWin_rate());
                item.setPrint_win_rate(print_win_rate);

                print_game_difference = n_formatter2.format(item.getGame_difference());
                item.setPrint_game_difference(print_game_difference);
            }

            return list;
        }

        for(RankingVO item : list){
            print_date = formatter2.format(item.getR_date());
            item.setPrint_date(print_date);

            print_full_date = formatter4.format(item.getR_date());
            item.setPrint_full_date(print_full_date);

            print_win_rate = n_formatter.format(item.getWin_rate());
            item.setPrint_win_rate(print_win_rate);

            print_game_difference = n_formatter2.format(item.getGame_difference());
            item.setPrint_game_difference(print_game_difference);
        }

        return list;
    }
}
