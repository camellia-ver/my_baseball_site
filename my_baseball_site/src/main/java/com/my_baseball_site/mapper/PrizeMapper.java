package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.GoldenGloveVO;
import com.my_baseball_site.vo.PlayerPrizeVO;

@Mapper
public interface PrizeMapper {
    public List<PlayerPrizeVO> selectPlayerPrize();
    public List<GoldenGloveVO> selectGoldenGlove();
}
