package com.my_baseball_site.vo;

import java.time.Year;

import lombok.Data;

@Data
public class FuturesHitterRecordVO {
    private Integer fhr_seq;
    private Year fhr_year;
    private Float fhr_AVG;
    private String fhr_G;
    private String fhr_PA;
    private String fhr_AB;
    private String fhr_R;
    private String fhr_H;
    private String fhr_2B;
    private String fhr_3B;
    private String fhr_HR;
    private String fhr_TB;
    private String fhr_RBI;
    private String fhr_SB;
    private String fhr_CS;
    private String fhr_BB;
    private String fhr_HBP;
    private String fhr_SO;
    private String fhr_GDP;
    private Float fhr_SLG;
    private Float fhr_OBP;
    private String fhr_E;
    private String fhr_name;
    private String fhr_birth;

    private String print_avg;
    private String print_slg;
    private String print_obp;
}
