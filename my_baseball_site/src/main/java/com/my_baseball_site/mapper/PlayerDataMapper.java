package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.FuturesHitterRecordVO;
import com.my_baseball_site.vo.FuturesPitcherRecordVO;
import com.my_baseball_site.vo.PlayerDataVO;
import com.my_baseball_site.vo.PlayerHitterRecordBasicVO;
import com.my_baseball_site.vo.PlayerPitcherRecordBasicVO;

@Mapper
public interface PlayerDataMapper {
    public List<PlayerDataVO> selectPlayerDataByPosition(String position);
    public List<PlayerDataVO> selectPlayerDataByName(String name);

    public PlayerDataVO selectPlayerProfile(String name,String birth);
    public List<PlayerPitcherRecordBasicVO> selectPitcherRecord(String name,String birth);
    public List<PlayerHitterRecordBasicVO> selectHitterRecord(String name,String birth);
    public List<FuturesPitcherRecordVO> selectFuturesPitcherRecord(String name,String birth);
    public List<FuturesHitterRecordVO> selectFuturesHitterRecord(String name,String birth);
}
