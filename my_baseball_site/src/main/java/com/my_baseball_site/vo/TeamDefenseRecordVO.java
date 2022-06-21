package com.my_baseball_site.vo;

import java.time.Year;

import lombok.Data;

@Data
public class TeamDefenseRecordVO {
    private Integer tdr_seq;
    private String tdr_team_name;
    private Integer tdr_G;
    private Integer tdr_E;
    private Integer tdr_PKO;
    private Integer tdr_PO;
    private Integer tdr_A;
    private Integer tdr_DP;
    private Float tdr_FPCT;
    private Integer tdr_PB;
    private Integer tdr_SB;
    private Integer tdr_CS;
    private Float tdr_CS_PERSENT;
    private Year tdr_year;

    private String print_fpct;
}
