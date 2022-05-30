package com.my_baseball_site.mapper;

import java.util.Date;
import java.util.List;

import com.my_baseball_site.vo.RankingVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankingMapper {
    public List<RankingVO> selectRankingToday();
    public List<RankingVO> selectRankingByDate(Date date);
}