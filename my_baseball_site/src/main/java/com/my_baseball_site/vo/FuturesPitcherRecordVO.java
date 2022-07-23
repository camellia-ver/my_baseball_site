package com.my_baseball_site.vo;

import java.time.Year;

import lombok.Data;

@Data
public class FuturesPitcherRecordVO {
    private Integer fpr_seq;
    private Year fpr_year;
    private Float fpr_ERA;
    private String fpr_G;
    private String fpr_CG;
    private String fpr_SHO;
    private String fpr_W;
    private String fpr_L;
    private String fpr_SV;
    private String fpr_HLD;
    private Float fpr_WPCT;
    private String fpr_TBF;
    private String fpr_IP;
    private String fpr_H;
    private String fpr_HR;
    private String fpr_BB;
    private String fpr_HBP;
    private String fpr_SO;
    private String fpr_R;
    private String fpr_ER;
    private String fpr_name;
    private String fpr_birth;

    private String print_ear;
    private String print_wpct;
}
