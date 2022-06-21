package com.my_baseball_site.vo;

import java.time.Year;

import lombok.Data;

@Data
public class TeamRunnerRecordVO {
    private Integer trr_seq;
    private String trr_team_name;
    private Integer trr_G;
    private Integer trr_SBA;
    private Integer trr_SB;
    private Integer trr_CS;
    private Float trr_SB_PERSENT;
    private Integer trr_OOB;
    private Integer trr_PKO;
    private Year tdr_year;
}
