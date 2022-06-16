package com.my_baseball_site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_baseball_site.vo.RegisterVO;

@Mapper
public interface RegisterMapper {
    public List<RegisterVO> selectRegister(String date);
}
