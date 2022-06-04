package com.my_baseball_site.mapper;

import java.util.Date;
import java.util.List;

import com.my_baseball_site.vo.RankingVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankingMapper {
    public List<RankingVO> selectRankingByDate(String date);
    public List<Integer> selectYear();
    public Date selectStartDate(String date);
}