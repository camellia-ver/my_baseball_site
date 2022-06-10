package com.my_baseball_site.vo;

import lombok.Data;

@Data
public class PlayerPrizeVO {
    private Integer pp_seq;    
    private String pp_year;
    private String kbo_mvp_name;
    private String kbo_mvp_team;
    private String kbo_mvp_position;
    private String kbo_new_man_name;
    private String kbo_new_man_team;
    private String kbo_new_man_position;
    private String kbo_all_star_mvp_name;
    private String kbo_all_star_mvp_team;
    private String kbo_all_star_mvp_position;
    private String kbo_korea_series_mvp_name;
    private String kbo_korea_series_mvp_team;
    private String kbo_korea_series_mvp_position;    
}
