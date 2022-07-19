package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.PlayerDefensRecordVO;
import com.my_baseball_site.vo.PlayerHitterRecordBasicVO;
import com.my_baseball_site.vo.PlayerHitterRecordDetailVO;
import com.my_baseball_site.vo.PlayerPitcherRecordBasicVO;
import com.my_baseball_site.vo.PlayerPitcherRecordDetailVO;
import com.my_baseball_site.vo.PlayerRunnerRecordVO;
import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamHitterRecordVO;
import com.my_baseball_site.vo.TeamPitcherRecordVO;
import com.my_baseball_site.vo.TeamRunnerRecordVO;

@Mapper
public interface RecordMapper {
    public List<Integer> selectRegularSeriseYear();

    public List<TeamDefenseRecordVO> selectTeamDefenseRecord(String year);
    public List<TeamRunnerRecordVO> selectTeamRunnerRecord(String year);
    public List<TeamHitterRecordVO> selectTeamHitterRecord(String year,String series);
    public List<TeamPitcherRecordVO> selectTeamPitcherRecord(String year,String series);

    public List<PlayerDefensRecordVO> selectPlayerDefenseRecord(String year,String position);
    public List<PlayerRunnerRecordVO> selectPlayerRunnerRecord(String year,String position);
    public List<PlayerHitterRecordBasicVO> selectPlayerHitterRecordBasic(String year,String series,String position);
    public List<PlayerHitterRecordDetailVO> selectPlayerHitterRecordDetail(String year,String position);
    public List<PlayerPitcherRecordBasicVO> selectPlayerPitcherRecordBasic(String year,String series);
    public List<PlayerPitcherRecordDetailVO> selectPlayerPitcherRecordDetail(String year);
}
