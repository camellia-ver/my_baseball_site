package com.my_baseball_site.mapper;

import java.util.List;

import com.my_baseball_site.vo.ScheduleGameResultVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleGameResultMapper {
    List<ScheduleGameResultVO> selectScheduleThreeGame(String date); 
    ScheduleGameResultVO selectRecentlyGameResult(String date);
    List<ScheduleGameResultVO> selectScheduleGameResultByYearMonthSeason(String year,String month,String season);
    Integer isGame(String date);
    List<Integer> selectYear();
}
