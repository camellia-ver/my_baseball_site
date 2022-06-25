package com.my_baseball_site.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_baseball_site.mapper.RecordMapper;
import com.my_baseball_site.vo.PlayerDefensRecordVO;
import com.my_baseball_site.vo.PlayerRunnerRecordVO;
import com.my_baseball_site.vo.TeamDefenseRecordVO;
import com.my_baseball_site.vo.TeamHitterRecordVO;
import com.my_baseball_site.vo.TeamPitcherRecordVO;
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
        DecimalFormat n_formatter = new DecimalFormat("0.0");

        List<TeamRunnerRecordVO> list = mapper.selectTeamRunnerRecord(cur_year);

        for(TeamRunnerRecordVO item:list){
            item.setPrint_sb_persent(n_formatter.format(item.getTrr_SB_PERSENT()));
        }

        return list;
    }
    public List<TeamRunnerRecordVO> selectTeamRunnerRecord(String year){
        DecimalFormat n_formatter = new DecimalFormat("0.0");

        List<TeamRunnerRecordVO> list = mapper.selectTeamRunnerRecord(year);

        for(TeamRunnerRecordVO item:list){
            item.setPrint_sb_persent(n_formatter.format(item.getTrr_SB_PERSENT()));
        }

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

    public List<TeamPitcherRecordVO> selectTeamPitcherRecord(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        DecimalFormat n_formatter = new DecimalFormat("0.00");
        DecimalFormat n_formatter2 = new DecimalFormat("0.000");

        List<TeamPitcherRecordVO> list = mapper.selectTeamPitcherRecord(cur_year,"정규시즌");

        for(TeamPitcherRecordVO item:list){
            item.setPrint_era(n_formatter.format(item.getTpr_ERA()));
            item.setPrint_wptc(n_formatter2.format(item.getTpr_WPCT()));
            item.setPrint_whip(n_formatter.format(item.getTpr_WHIP()));
            item.setPrint_avg(n_formatter2.format(item.getTpr_AVG()));
        }

        return list;
    }
    public List<TeamPitcherRecordVO> selectTeamPitcherRecord(String year,String series){
        DecimalFormat n_formatter = new DecimalFormat("0.00");
        DecimalFormat n_formatter2 = new DecimalFormat("0.000");

        List<TeamPitcherRecordVO> list = mapper.selectTeamPitcherRecord(year,series);

        for(TeamPitcherRecordVO item:list){
            item.setPrint_era(n_formatter.format(item.getTpr_ERA()));
            item.setPrint_wptc(n_formatter2.format(item.getTpr_WPCT()));

            if(series.equals("정규시즌")){
                item.setPrint_whip(n_formatter.format(item.getTpr_WHIP()));
                item.setPrint_avg(n_formatter2.format(item.getTpr_AVG()));
            }
        }

        return list;
    }

    public List<PlayerDefensRecordVO> selectPlayerDefenseRecord(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        DecimalFormat n_formatter = new DecimalFormat("0.0");
        DecimalFormat n_formatter2 = new DecimalFormat("0.000");
        
        List<PlayerDefensRecordVO> list = mapper.selectPlayerDefenseRecord(cur_year, "전체");
    
        for(PlayerDefensRecordVO item:list){
            item.setPrint_fpct(n_formatter2.format(item.getPdr_FPCT()));
            item.setPrint_cs_persent(n_formatter.format(item.getPdr_CS_PERSENT()));
        }

        return list;
    }
    public List<PlayerDefensRecordVO> selectPlayerDefenseRecord(String year,String position){
        DecimalFormat n_formatter = new DecimalFormat("0.0");
        DecimalFormat n_formatter2 = new DecimalFormat("0.000");
        
        List<PlayerDefensRecordVO> list = null;

        if(position.equals("전체") || position.equals("포수"))
            list = mapper.selectPlayerDefenseRecord(year, position);
        else if(position.equals("내야수")){
            list = mapper.selectPlayerDefenseRecord(year, "1루수");
            list.addAll(mapper.selectPlayerDefenseRecord(year, "2루수"));
            list.addAll(mapper.selectPlayerDefenseRecord(year, "3루수"));
            list.addAll(mapper.selectPlayerDefenseRecord(year, "유격수"));
        }
        else if(position.equals("외야수")){
            list = mapper.selectPlayerDefenseRecord(year, "좌익수");
            list.addAll(mapper.selectPlayerDefenseRecord(year, "중견수"));
            list.addAll(mapper.selectPlayerDefenseRecord(year, "우익수"));
        }
    
        for(PlayerDefensRecordVO item:list){
            item.setPrint_fpct(n_formatter2.format(item.getPdr_FPCT()));
            item.setPrint_cs_persent(n_formatter.format(item.getPdr_CS_PERSENT()));
        }

        return list;
    }

    public List<PlayerRunnerRecordVO> selectPlayerRunnerRecord(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        DecimalFormat n_formatter = new DecimalFormat("0.0");
        
        List<PlayerRunnerRecordVO> list = mapper.selectPlayerRunnerRecord(cur_year, "전체");
    
        for(PlayerRunnerRecordVO item:list){
            item.setPrint_sb_persent(n_formatter.format(item.getPrr_SB_PERSENT()));
        }

        return list;
    }
    public List<PlayerRunnerRecordVO> selectPlayerRunnerRecord(String year,String position){
        DecimalFormat n_formatter = new DecimalFormat("0.0");
        
        List<PlayerRunnerRecordVO> list = mapper.selectPlayerRunnerRecord(year, position);
    
        for(PlayerRunnerRecordVO item:list){
            item.setPrint_sb_persent(n_formatter.format(item.getPrr_SB_PERSENT()));
        }

        return list;
    }
}
