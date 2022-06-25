package com.my_baseball_site.vo;

import java.time.Year;
import java.util.Date;

import lombok.Data;

@Data
public class PlayerRunnerRecordVO {
    private Integer prr_seq;
    private String prr_player_name;
    private Integer prr_G;
    private Integer prr_SBA;
    private Integer prr_SB;
    private Integer prr_CS;
    private Float prr_SB_PERSENT;
    private Integer prr_OOB;
    private Integer prr_PKO;
    private Year prr_year;
    private Date prr_birth;
    private String prr_position;

    private String print_sb_persent;
}
