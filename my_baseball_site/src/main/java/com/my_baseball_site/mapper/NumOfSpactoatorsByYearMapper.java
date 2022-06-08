package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.NumOfSpactoatorsByYearVO;

@Mapper
public interface NumOfSpactoatorsByYearMapper {
    public List<NumOfSpactoatorsByYearVO> selectSumYear();
    public List<NumOfSpactoatorsByYearVO> selectAvgOneGame();
}
