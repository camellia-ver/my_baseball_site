package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.NumOfSpactoatorsVO;

@Mapper
public interface NumOfSpactoatorsMapper {
    public List<NumOfSpactoatorsVO> selectNumOfSpactoators(String year,String month,String home_away,String team,String stadium,String day_of_week);
    public List<Integer> selectYear();
    public List<String> selectBaseballStadium();
    public List<String> selectTeams();

    public List<NumOfSpactoatorsVO> selectSumYear();
    public List<NumOfSpactoatorsVO> selectAvgOneGame();

    public List<NumOfSpactoatorsVO> selectHomeAwayAvg();
    public List<NumOfSpactoatorsVO> selectStadiumAvg();
    public List<NumOfSpactoatorsVO> selectMonthAvg();
    public List<NumOfSpactoatorsVO> selectDayAvg();
    public List<NumOfSpactoatorsVO> selectDayOfTheWeeksAvg();
    public List<NumOfSpactoatorsVO> selectTeamHomeAvg();
    public List<NumOfSpactoatorsVO> selectTeamAwayAvg();
}
