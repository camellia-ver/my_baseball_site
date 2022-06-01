package com.my_baseball_site.service;

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

        return list;
    }
}
