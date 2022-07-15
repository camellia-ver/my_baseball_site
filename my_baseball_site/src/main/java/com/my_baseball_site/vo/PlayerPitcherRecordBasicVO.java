package com.my_baseball_site.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PlayerPitcherRecordBasicVO {
    private Integer pprb_seq;
    private String pprb_player_name;
    private Float pprb_ERA;
    private Integer pprb_G;
    private Integer pprb_CG;
    private Integer pprb_SHO;
    private Integer pprb_W;
    private Integer pprb_L;
    private Integer pprb_SV;
    private Integer pprb_HLD;
    private Float pprb_WPCT;
    private Integer pprb_TBF;
    private String pprb_IP;
    private Integer pprb_H;
    private Integer pprb_HR;
    private Integer pprb_BB;
    private Integer pprb_HBP;
    private Integer pprb_SO;
    private Integer pprb_R;
    private Integer pprb_ER;
    private Float pprb_WHIP;
    private Integer pprb_QS;
    private Integer pprb_BSV;
    private Integer pprb_NP;
    private Float pprb_AVG;
    private Integer pprb_2B;
    private Integer pprb_3B;
    private Integer pprb_SAC;
    private Integer pprb_SF;
    private Integer pprb_IBB;
    private Integer pprb_WP;
    private Integer pprb_BK;
    private Integer pprb_year;
    private String pprb_serise;
    private Date pprb_birth;

    private String print_wpct;
    private String print_whip;
    private String print_avg;
}
