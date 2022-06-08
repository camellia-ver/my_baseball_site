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
    private Float win_rate;
    private Float game_difference;
    private String last_10_matches;
    private String continuity;
    private String home;
    private String away;
    private Date r_date;
    private String uniqueness;

    private String year;
    private String print_game_difference;
    private String print_win_rate;
    private String print_date;
    private String print_full_date;
    private String max_date;
}