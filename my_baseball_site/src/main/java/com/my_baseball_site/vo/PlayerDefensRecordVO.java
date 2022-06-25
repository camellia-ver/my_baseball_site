package com.my_baseball_site.vo;

import java.time.Year;
import java.util.Date;

import lombok.Data;

@Data
public class PlayerDefensRecordVO {
    private Integer pdr_seq;
    private String pdr_player_name;
    private String pdr_position;
    private Integer pdr_G;
    private Integer pdr_GS;
    private String pdr_IP;
    private Integer pdr_E;
    private Integer pdr_PKO;
    private Integer pdr_PO;
    private Integer pdr_A;
    private Integer pdr_DP;
    private Float pdr_FPCT;
    private Integer pdr_PB;
    private Integer pdr_SB;
    private Integer pdr_CS;
    private Float pdr_CS_PERSENT;
    private Year pdr_year;
    private Date pdr_birth;

    private String print_fpct;
    private String print_cs_persent;
}
