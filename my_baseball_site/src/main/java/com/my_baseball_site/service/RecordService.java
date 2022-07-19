package com.my_baseball_site.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_baseball_site.mapper.RecordMapper;
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
        String print_sb_persent;

        List<PlayerRunnerRecordVO> list = mapper.selectPlayerRunnerRecord(cur_year, "전체");
    
        for(PlayerRunnerRecordVO item:list){
            print_sb_persent = n_formatter.format(item.getPrr_SB_PERSENT());

            if(print_sb_persent.equals("-1.0"))
                print_sb_persent = "-";

            item.setPrint_sb_persent(print_sb_persent);
        }

        return list;
    }
    public List<PlayerRunnerRecordVO> selectPlayerRunnerRecord(String year,String position){
        DecimalFormat n_formatter = new DecimalFormat("0.0");
        String print_sb_persent;

        List<PlayerRunnerRecordVO> list = mapper.selectPlayerRunnerRecord(year, position);
    
        for(PlayerRunnerRecordVO item:list){
            print_sb_persent = n_formatter.format(item.getPrr_SB_PERSENT());

            if(print_sb_persent.equals("-1.0"))
                print_sb_persent = "-";

        }

        return list;
    }

    public List<PlayerHitterRecordBasicVO> selectPlayerHitterRecordBasic(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        DecimalFormat n_formatter = new DecimalFormat("0.000");
        String print_formatting;

        List<PlayerHitterRecordBasicVO> list = mapper.selectPlayerHitterRecordBasic(cur_year,"정규시즌","전체");
        
        for(PlayerHitterRecordBasicVO item:list){
            print_formatting = n_formatter.format(item.getPhrb_AVG());
            if(print_formatting.equals("-1.000"))
                print_formatting = "-";
            else if(print_formatting.equals("0.000"))
                print_formatting = "0";
            item.setPrint_avg(print_formatting);
            
            print_formatting = n_formatter.format(item.getPhrb_SLG());
            if(print_formatting.equals("-1.000"))
                print_formatting = "-";
            else if(print_formatting.equals("0.000"))
                print_formatting = "0";
            item.setPrint_slg(print_formatting);

            print_formatting = n_formatter.format(item.getPhrb_OBP());
            if(print_formatting.equals("-1.000"))
                print_formatting = "-";
            else if(print_formatting.equals("0.000"))
                print_formatting = "0";
            item.setPrint_obp(print_formatting);

            print_formatting = n_formatter.format(item.getPhrb_OPS());
            if(print_formatting.equals("-1.000"))
                print_formatting = "-";
            else if(print_formatting.equals("0.000"))
                print_formatting = "0";
            item.setPrint_ops(print_formatting);

            print_formatting = n_formatter.format(item.getPhrb_RISP());
            if(print_formatting.equals("-1.000"))
                print_formatting = "-";
            else if(print_formatting.equals("0.000"))
                print_formatting = "0";
            item.setPrint_risp(print_formatting);

            print_formatting = n_formatter.format(item.getPhrb_PH_BA());
            if(print_formatting.equals("-1.000"))
                print_formatting = "-";
            else if(print_formatting.equals("0.000"))
                print_formatting = "0";
            item.setPrint_ph_ba(print_formatting);
        }
        
        return list;
    }
    public List<PlayerHitterRecordBasicVO> selectPlayerHitterRecordBasic(String year,String series,String position){
        DecimalFormat n_formatter = new DecimalFormat("0.000");
        String print_formatting;
        
        List<PlayerHitterRecordBasicVO> list = mapper.selectPlayerHitterRecordBasic(year,series,position);
        
        for(PlayerHitterRecordBasicVO item:list){
            print_formatting = n_formatter.format(item.getPhrb_AVG());
            if(print_formatting.equals("-1.000"))
                print_formatting = "-";
            else if(print_formatting.equals("0.000"))
                print_formatting = "0";
            item.setPrint_avg(print_formatting);
            
            if(item.getPhrb_year() > 2002){
                if(item.getPhrb_SLG() == null){
                    item.setPrint_slg("-");
                }
                else{
                    print_formatting = n_formatter.format(item.getPhrb_SLG());
                    if(print_formatting.equals("-1.000"))
                        print_formatting = "-";
                    else if(print_formatting.equals("0.000"))
                        print_formatting = "0";
                    item.setPrint_slg(print_formatting);
                }
                
                if(item.getPhrb_OBP() == null){
                    item.setPrint_obp("-");
                }
                else{
                    print_formatting = n_formatter.format(item.getPhrb_OBP());
                    if(print_formatting.equals("-1.000"))
                        print_formatting = "-";
                    else if(print_formatting.equals("0.000"))
                        print_formatting = "0";
                    item.setPrint_obp(print_formatting);
                }
                
                if(item.getPhrb_OPS() == null){
                    item.setPrint_ops("-");
                }
                else{
                    print_formatting = n_formatter.format(item.getPhrb_OPS());
                    if(print_formatting.equals("-1.000"))
                        print_formatting = "-";
                    else if(print_formatting.equals("0.000"))
                        print_formatting = "0";
                    item.setPrint_ops(print_formatting);
                }
                
                if(item.getPhrb_RISP() == null){
                    item.setPrint_risp("-");
                }
                else{
                    print_formatting = n_formatter.format(item.getPhrb_RISP());
                    if(print_formatting.equals("-1.000"))
                        print_formatting = "-";
                    else if(print_formatting.equals("0.000"))
                        print_formatting = "0";
                    item.setPrint_risp(print_formatting);
                }
             
                if(item.getPhrb_PH_BA() == null){
                    item.setPrint_ph_ba("-");
                }
                else{
                    print_formatting = n_formatter.format(item.getPhrb_PH_BA());
                    if(print_formatting.equals("-1.000"))
                        print_formatting = "-";
                    else if(print_formatting.equals("0.000"))
                        print_formatting = "0";
                    item.setPrint_ph_ba(print_formatting);
                }
           
            }
        }
        
        return list;
    }
    public List<PlayerHitterRecordDetailVO> selectPlayerHitterRecordDetail(String year,String position){
        DecimalFormat n_formatter = new DecimalFormat("0.00");
        DecimalFormat n_formatter2 = new DecimalFormat("0.000");
        String print_formatting;

        List<PlayerHitterRecordDetailVO> list = mapper.selectPlayerHitterRecordDetail(year,position);
        
        for(PlayerHitterRecordDetailVO item:list){
            print_formatting = n_formatter.format(item.getPhrd_GO_AO());
            if(print_formatting.equals("-1.00")) print_formatting = "-";
            else if(print_formatting.equals("0.00")) print_formatting = "0";
            item.setPrint_go_ao(print_formatting);

            print_formatting = n_formatter.format(item.getPhrd_BB_K());
            if(print_formatting.equals("-1.00")) print_formatting = "-";
            else if(print_formatting.equals("0.00")) print_formatting = "0";
            item.setPrint_bb_k(print_formatting);

            print_formatting = n_formatter.format(item.getPhrd_P_PA());
            if(print_formatting.equals("-1.00")) print_formatting = "-";
            else if(print_formatting.equals("0.00")) print_formatting = "0";
            item.setPrint_p_pa(print_formatting);

            print_formatting = n_formatter2.format(item.getPhrd_ISOP());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_isop(print_formatting);

            print_formatting = n_formatter.format(item.getPhrd_XR());
            if(print_formatting.equals("-1.00")) print_formatting = "-";
            else if(print_formatting.equals("0.00")) print_formatting = "0";
            item.setPrint_xr(print_formatting);

            print_formatting = n_formatter2.format(item.getPhrd_GPA());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_gpa(print_formatting);
        }
        
        return list;
    }

    public List<PlayerPitcherRecordBasicVO> selectPlayerPitcherRecordBasic(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String cur_year = formatter.format(now.getTime());

        DecimalFormat n_formatter = new DecimalFormat("0.000");
        DecimalFormat n_formatter2 = new DecimalFormat("0.00");
        String print_formatting;

        List<PlayerPitcherRecordBasicVO> list = mapper.selectPlayerPitcherRecordBasic(cur_year,"정규시즌");
        
        for(PlayerPitcherRecordBasicVO item:list){
            print_formatting = n_formatter.format(item.getPprb_WPCT());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_wpct(print_formatting);

            if(item.getPprb_year() > 2002){
                print_formatting = n_formatter2.format(item.getPprb_WHIP());
                if(print_formatting.equals("-1.00")) print_formatting = "-";
                else if(print_formatting.equals("0.00")) print_formatting = "0";
                item.setPrint_whip(print_formatting);

                print_formatting = n_formatter.format(item.getPprb_AVG());
                if(print_formatting.equals("-1.000")) print_formatting = "-";
                else if(print_formatting.equals("0.000")) print_formatting = "0";
                item.setPrint_avg(print_formatting);
            }
        }
        
        return list;
    }
    public List<PlayerPitcherRecordBasicVO> selectPlayerPitcherRecordBasic(String year,String series){
        DecimalFormat n_formatter = new DecimalFormat("0.000");
        DecimalFormat n_formatter2 = new DecimalFormat("0.00");
        String print_formatting;

        List<PlayerPitcherRecordBasicVO> list = mapper.selectPlayerPitcherRecordBasic(year,series);
        
        for(PlayerPitcherRecordBasicVO item:list){
            print_formatting = n_formatter.format(item.getPprb_WPCT());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_wpct(print_formatting);

            if(item.getPprb_year() > 2002){
                if(item.getPprb_WHIP() == null){
                    item.setPrint_whip("-");
                }
                else{
                    print_formatting = n_formatter2.format(item.getPprb_WHIP());
                    if(print_formatting.equals("-1.00")) print_formatting = "-";
                    else if(print_formatting.equals("0.00")) print_formatting = "0";
                    item.setPrint_whip(print_formatting);
                }

                if(item.getPprb_AVG() == null){
                    item.setPrint_avg("-");
                }
                else{
                    print_formatting = n_formatter.format(item.getPprb_AVG());
                    if(print_formatting.equals("-1.000")) print_formatting = "-";
                    else if(print_formatting.equals("0.000")) print_formatting = "0";
                    item.setPrint_avg(print_formatting);
                }
            }
        }
        
        return list;
    }
    public List<PlayerPitcherRecordDetailVO> selectPlayerPitcherRecordDetail(String year){
        DecimalFormat n_formatter = new DecimalFormat("0.0");
        DecimalFormat n_formatter2 = new DecimalFormat("0.00");
        DecimalFormat n_formatter3 = new DecimalFormat("0.000");
        String print_formatting;

        List<PlayerPitcherRecordDetailVO> list = mapper.selectPlayerPitcherRecordDetail(year);
        
        for(PlayerPitcherRecordDetailVO item:list){
            print_formatting = n_formatter.format(item.getPprd_P_G());
            if(print_formatting.equals("-1.0")) print_formatting = "-";
            else if(print_formatting.equals("0.0")) print_formatting = "0";
            item.setPrint_p_g(print_formatting);

            print_formatting = n_formatter.format(item.getPprd_P_IP());
            if(print_formatting.equals("-1.0")) print_formatting = "-";
            else if(print_formatting.equals("0.0")) print_formatting = "0";
            item.setPrint_p_ip(print_formatting);

            print_formatting = n_formatter2.format(item.getPprd_GO_AO());
            if(print_formatting.equals("-1.0")) print_formatting = "-";
            else if(print_formatting.equals("0.0")) print_formatting = "0";
            item.setPrint_go_ao(print_formatting);

            print_formatting = n_formatter2.format(item.getPprd_K_9());
            if(print_formatting.equals("-1.00")) print_formatting = "-";
            else if(print_formatting.equals("0.00")) print_formatting = "0";
            item.setPrint_k_9(print_formatting);
            
            print_formatting = n_formatter2.format(item.getPprd_BB_9());
            if(print_formatting.equals("-1.00")) print_formatting = "-";
            else if(print_formatting.equals("0.00")) print_formatting = "0";
            item.setPrint_bb_9(print_formatting);

            print_formatting = n_formatter2.format(item.getPprd_K_BB());
            if(print_formatting.equals("-1.00")) print_formatting = "-";
            else if(print_formatting.equals("0.00")) print_formatting = "0";
            item.setPrint_k_bb(print_formatting);

            print_formatting = n_formatter3.format(item.getPprd_BABIP());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_babip(print_formatting);

            print_formatting = n_formatter3.format(item.getPprd_OBP());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_obp(print_formatting);

            print_formatting = n_formatter3.format(item.getPprd_SLG());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_slg(print_formatting);

            print_formatting = n_formatter3.format(item.getPprd_OPS());
            if(print_formatting.equals("-1.000")) print_formatting = "-";
            else if(print_formatting.equals("0.000")) print_formatting = "0";
            item.setPrint_ops(print_formatting);
        }
        
        return list;
    }
}
