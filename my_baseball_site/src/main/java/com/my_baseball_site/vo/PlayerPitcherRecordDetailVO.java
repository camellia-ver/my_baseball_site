package com.my_baseball_site.vo;

import java.time.Year;
import java.util.Date;

import lombok.Data;

@Data
public class PlayerPitcherRecordDetailVO {
    private Integer pprd_seq;
    private String pprd_player_name;
    private Float pprd_ERA;
    private Integer pprd_GS;
    private Integer pprd_Wgs;
    private Integer pprd_Wgr;
    private Integer pprd_GF;
    private Integer pprd_SVO;
    private Integer pprd_TS;
    private Integer pprd_GDP;
    private Integer pprd_GO;
    private Integer pprd_AO;
    private Float pprd_GO_AO;
    private Float pprd_BABIP;
    private Float pprd_P_G;
    private Float pprd_P_IP;
    private Float pprd_K_9;
    private Float pprd_BB_9;
    private Float pprd_K_BB;
    private Float pprd_OBP;
    private Float pprd_SLG;
    private Float pprd_OPS;
    private Year pprd_year;
    private Date pprd_birth;

    private String print_go_ao;
    private String print_babip;
    private String print_p_g;
    private String print_p_ip;
    private String print_k_9;
    private String print_bb_9;
    private String print_k_bb;
    private String print_obp;
    private String print_slg;
    private String print_ops;
}
