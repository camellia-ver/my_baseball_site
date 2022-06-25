package com.my_baseball_site.vo;

import java.time.Year;
import java.util.Date;

import lombok.Data;

@Data
public class PlayerHitterRecordBasicVO {
    private Integer phrb_seq;
    private String phrb_player_name;
    private Float phrb_AVG;
    private Integer phrb_G;
    private Integer phrb_PA;
    private Integer phrb_AB;
    private Integer phrb_R;
    private Integer phrb_H;
    private Integer phrb_2B;
    private Integer phrb_3B;
    private Integer phrb_HR;
    private Integer phrb_TB;
    private Integer phrb_RBI;
    private Integer phrb_SB;
    private Integer phrb_CS;
    private Integer phrb_SAC;
    private Integer phrb_SF;
    private Integer phrb_BB;
    private Integer phrb_IBB;
    private Integer phrb_HBP;
    private Integer phrb_SO;
    private Integer phrb_GDP;
    private Integer phrb_E;
    private Float phrb_SLG;
    private Float phrb_OBP;
    private Float phrb_OPS;
    private Integer phrb_MH;
    private Float phrb_RISP;
    private Float phrb_PH_BA;
    private Year phrb_year;
    private String phrb_series;
    private Date phrb_birth;
    private String phrb_position;

    private String print_avg;
    private String print_slg;
    private String print_obp;
    private String print_ops;
    private String print_risp;
    private String print_ph_ba;
}
