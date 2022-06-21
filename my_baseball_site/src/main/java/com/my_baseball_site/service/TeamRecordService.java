package com.my_baseball_site.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_baseball_site.mapper.TeamRecordMapper;
import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamHitterRecordVO;
import com.my_baseball_site.vo.TeamRunnerRecordVO;

@Service
public class TeamRecordService {
    @Autowired TeamRecordMapper mapper;

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

    public List<TeamHitterRecordVO> selectTeamHitterRecord(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        DecimalFormat n_formatter = new DecimalFormat("0.000");

        List<TeamHitterRecordVO> list = mapper.selectTeamHitterRecord(cur_year,"정규시즌");

        for(TeamHitterRecordVO item:list){
            item.setPrint_avg(n_formatter.format(item.getThr_AVG()));
            item.setPrint_slg(n_formatter.format(item.getThr_SLG()));
            item.setPrint_risp(n_formatter.format(item.getThr_RISP()));
            item.setPrint_ph_ba(n_formatter.format(item.getThr_PH_BA()));
            item.setPrint_ops(n_formatter.format(item.getThr_OPS()));
            item.setPrint_obp(n_formatter.format(item.getThr_OBP()));
        }

        return list;
    }
    public List<TeamHitterRecordVO> selectTeamHitterRecord(String year,String series){
        DecimalFormat n_formatter = new DecimalFormat("0.000");

        List<TeamHitterRecordVO> list = mapper.selectTeamHitterRecord(year,series);

        for(TeamHitterRecordVO item:list){
            item.setPrint_avg(n_formatter.format(item.getThr_AVG()));
            
            if(series.equals("정규시즌")){
                item.setPrint_slg(n_formatter.format(item.getThr_SLG()));
                item.setPrint_risp(n_formatter.format(item.getThr_RISP()));
                item.setPrint_ph_ba(n_formatter.format(item.getThr_PH_BA()));
                item.setPrint_ops(n_formatter.format(item.getThr_OPS()));
                item.setPrint_obp(n_formatter.format(item.getThr_OBP()));
            }
        }

        return list;
    }
}
