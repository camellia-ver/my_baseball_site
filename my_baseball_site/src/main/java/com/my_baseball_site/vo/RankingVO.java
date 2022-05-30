package com.my_baseball_site.vo;

import java.util.Date;

import lombok.Data;

@Data
public class RankingVO {
    private Integer r_seq;
    private Integer no;
    private String team_name;
    private Integer game;
    private Integer win;
    private Integer lose;
    private Integer tie;
    private float win_rate;
    private Integer game_difference;
    private String last_10_matches;
    private String continuity;
    private String home;
    private String away;
    private Date r_date;
    private Integer uniqueness;
}