package com.my_baseball_site.vo;

import java.time.Year;

import lombok.Data;

@Data
public class TeamPitcherRecordVO {
    private Integer tpr_seq;
    private String tpr_team_name;
    private Float tpr_ERA;
    private Integer tpr_G;
    private Integer tpr_W;
    private Integer tpr_L;
    private Integer tpr_SV;
    private Integer tpr_HLD;
    private Float tpr_WPCT;
    private String tpr_IP;
    private Integer tpr_H;
    private Integer tpr_HR;
    private Integer tpr_BB;
    private Integer tpr_HBP;
    private Integer tpr_SO;
    private Integer tpr_R;
    private Integer tpr_ER;
    private Float tpr_WHIP;
    private Integer tpr_CG;
    private Integer tpr_SHO;
    private Integer tpr_QS;
    private Integer tpr_BSV;
    private Integer tpr_TBF;
    private Integer tpr_NP;
    private Float tpr_AVG;
    private Integer tpr_2B;
    private Integer tpr_3B;
    private Integer tpr_SAC;
    private Integer tpr_SF;
    private Integer tpr_IBB;
    private Integer tpr_WP;
    private Integer tpr_BK;
    private Year tpr_year;
    private String tpr_series;

    private String print_era;
    private String print_wptc;
    private String print_whip;
    private String print_avg;
}
