package com.my_baseball_site.vo;

import java.time.Year;
import java.util.Date;

import lombok.Data;

@Data
public class PlayerHitterRecordDetailVO {
    private Integer phrd_seq;
    private String phrd_player_name;
    private Integer phrd_XBH;
    private Integer phrd_GO;
    private Integer phrd_AO;
    private Float phrd_GO_AO;
    private Integer phrd_GW_RBI;
    private Float phrd_BB_K;
    private Float phrd_P_PA;
    private Float phrd_ISOP;
    private Float phrd_XR;
    private Float phrd_GPA;
    private Year phrd_year;
    private Date phrd_birth;
    private String phrd_position;

    private String print_go_ao;
    private String print_bb_k;
    private String print_p_pa;
    private String print_isop;
    private String print_xr;
    private String print_gpa;
}
