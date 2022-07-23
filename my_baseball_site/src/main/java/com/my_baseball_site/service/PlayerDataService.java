package com.my_baseball_site.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_baseball_site.mapper.PlayerDataMapper;
import com.my_baseball_site.vo.FuturesHitterRecordVO;
import com.my_baseball_site.vo.FuturesPitcherRecordVO;
import com.my_baseball_site.vo.PlayerHitterRecordBasicVO;
import com.my_baseball_site.vo.PlayerPitcherRecordBasicVO;

@Service
public class PlayerDataService {
    @Autowired PlayerDataMapper mapper;

    public List<PlayerPitcherRecordBasicVO> selectPitcherRecord(String name,String birth){
        DecimalFormat n_formatter = new DecimalFormat("0.000");
        DecimalFormat n_formatter2 = new DecimalFormat("0.00");
        String print_formatting;

        List<PlayerPitcherRecordBasicVO> list = mapper.selectPitcherRecord(name, birth);
        
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
    public List<PlayerHitterRecordBasicVO> selectHitterRecord(String name,String birth){
        DecimalFormat n_formatter = new DecimalFormat("0.000");
        String print_formatting;
        
        List<PlayerHitterRecordBasicVO> list = mapper.selectHitterRecord(name, birth);
        
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
    public List<FuturesPitcherRecordVO> selectFuturesPitcherRecord(String name,String birth){
        DecimalFormat n_formatter = new DecimalFormat("0.00");
        DecimalFormat n_formatter2 = new DecimalFormat("0.000");
        String print_formatting;

        List<FuturesPitcherRecordVO> list = mapper.selectFuturesPitcherRecord(name, birth);
    
        for(FuturesPitcherRecordVO item:list){
            if(item.getFpr_ERA() == null){
                item.setPrint_ear("-");
            }
            else{
                print_formatting = n_formatter.format(item.getFpr_ERA());
                if(print_formatting.equals("-1.00"))
                    print_formatting = "-";
                else if(print_formatting.equals("0.00"))
                    print_formatting = "0";
                item.setPrint_ear(print_formatting);
            }

            if(item.getFpr_WPCT() == null){
                item.setPrint_wpct("-");
            }
            else{
                print_formatting = n_formatter2.format(item.getFpr_WPCT());
                if(print_formatting.equals("-1.000"))
                    print_formatting = "-";
                else if(print_formatting.equals("0.000"))
                    print_formatting = "0";
                item.setPrint_wpct(print_formatting);
            }
        }

        return list;
    }
    public List<FuturesHitterRecordVO> selectFuturesHitterRecord(String name,String birth){
        DecimalFormat n_formatter = new DecimalFormat("0.000");
        String print_formatting;

        List<FuturesHitterRecordVO> list = mapper.selectFuturesHitterRecord(name, birth);
    
        for(FuturesHitterRecordVO item:list){
            if(item.getFhr_AVG() == null){
                item.setPrint_avg("-");
            }
            else{
                print_formatting = n_formatter.format(item.getFhr_AVG());
                if(print_formatting.equals("-1.000"))
                    print_formatting = "-";
                else if(print_formatting.equals("0.000"))
                    print_formatting = "0";
                item.setPrint_avg(print_formatting);
            }

            if(item.getFhr_SLG() == null){
                item.setPrint_slg("-");
            }
            else{
                print_formatting = n_formatter.format(item.getFhr_SLG());
                if(print_formatting.equals("-1.000"))
                    print_formatting = "-";
                else if(print_formatting.equals("0.000"))
                    print_formatting = "0";
                item.setPrint_slg(print_formatting);
            }

            if(item.getFhr_OBP() == null){
                item.setPrint_obp("-");;
            }
            else{
                print_formatting = n_formatter.format(item.getFhr_OBP());
                if(print_formatting.equals("-1.000"))
                    print_formatting = "-";
                else if(print_formatting.equals("0.000"))
                    print_formatting = "0";
                item.setPrint_obp(print_formatting);
            }
        }

        return list;
    }
}
