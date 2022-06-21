package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamHitterRecordVO;
import com.my_baseball_site.vo.TeamRunnerRecordVO;

@Mapper
public interface TeamRecordMapper {
    public List<Integer> selectRegularSeriseYear();

    public List<TeamDefenseRecordVO> selectTeamDefenseRecord(String year);
    public List<TeamRunnerRecordVO> selectTeamRunnerRecord(String year);
    public List<TeamHitterRecordVO> selectTeamHitterRecord(String year,String series);
}
