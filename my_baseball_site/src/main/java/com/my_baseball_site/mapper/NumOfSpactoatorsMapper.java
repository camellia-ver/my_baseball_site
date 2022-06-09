package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.NumOfSpactoatorsByYearVO;
import com.my_baseball_site.vo.NumOfSpactoatorsGraphVO;
import com.my_baseball_site.vo.NumOfSpactoatorsVO;

@Mapper
public interface NumOfSpactoatorsMapper {
    public List<NumOfSpactoatorsVO> selectNumOfSpactoators(String year,String month,String home_away,String stadium,String day_of_week);
    public List<Integer> selectYear();
    public List<String> selectBaseballStadium();

    public List<NumOfSpactoatorsByYearVO> selectSumYear();
    public List<NumOfSpactoatorsByYearVO> selectAvgOneGame();

    public List<NumOfSpactoatorsGraphVO> selectHomeAwaySum();
    public List<NumOfSpactoatorsGraphVO> selectStadiumSum();
    public List<NumOfSpactoatorsGraphVO> selectDayOfTheWeeksSum();
    public List<NumOfSpactoatorsGraphVO> selectTeamHomeSum();
    public List<NumOfSpactoatorsGraphVO> selectTeamAwaySum();
}
