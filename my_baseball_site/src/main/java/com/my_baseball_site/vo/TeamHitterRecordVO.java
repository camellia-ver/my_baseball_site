package com.my_baseball_site.vo;

import java.time.Year;

import lombok.Data;

@Data
public class TeamHitterRecordVO {
    private Integer thr_seq;
    private String thr_team_name;
    private Float thr_AVG;
    private Integer thr_G;
    private Integer thr_PA;
    private Integer thr_AB;
    private Integer thr_R;
    private Integer thr_H;
    private Integer thr_2B;
    private Integer thr_3B;
    private Integer thr_HR;
    private Integer thr_TB;
    private Integer thr_RBI;
    private Integer thr_SAC;
    private Integer thr_SF;
    private Integer thr_BB;
    private Integer thr_IBB;
    private Integer thr_HBP;
    private Integer thr_SO;
    private Integer thr_GDP;
    private Float thr_SLG;
    private Float thr_OBP;
    private Float thr_OPS;
    private Integer thr_MH;
    private Integer thr_RISP;
    private Integer thr_PH_BA;
    private Integer thr_SB;
    private Integer thr_CS;
    private Integer thr_E;
    private Year thr_year;
    private String thr_series;

    private String print_avg;
    private String print_slg;
    private String print_obp;
    private String print_ops;
    private String print_risp;
    private String print_ph_ba;
}
