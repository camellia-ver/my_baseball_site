package com.my_baseball_site.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_baseball_site.mapper.RecordMapper;
import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamRunnerRecordVO;

@Service
public class RecordService {
    @Autowired RecordMapper mapper;

    public List<TeamDefenseRecordVO> selectTeamDefenseRecord(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        DecimalFormat n_formatter = new DecimalFormat("0.000");

        List<TeamDefenseRecordVO> list = mapper.selectTeamDefenseRecord(cur_year);

        for(TeamDefenseRecordVO item:list){
            item.setPrint_fpct(n_formatter.format(item.getTdr_FPCT()));
        }

        return list;
    }
    public List<TeamDefenseRecordVO> selectTeamDefenseRecord(String year){
        DecimalFormat n_formatter = new DecimalFormat("0.000");

        List<TeamDefenseRecordVO> list = mapper.selectTeamDefenseRecord(year);

        for(TeamDefenseRecordVO item:list){
            item.setPrint_fpct(n_formatter.format(item.getTdr_FPCT()));
        }

        return list;
    }


    public List<TeamRunnerRecordVO> selectTeamRunnerRecord(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        List<TeamRunnerRecordVO> list = mapper.selectTeamRunnerRecord(cur_year);

        return list;
    }
    public List<TeamRunnerRecordVO> selectTeamRunnerRecord(String year){
        List<TeamRunnerRecordVO> list = mapper.selectTeamRunnerRecord(year);

        return list;
    }
}
