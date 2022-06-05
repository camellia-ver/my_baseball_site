package com.my_baseball_site.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ScheduleGameResultVO {
    private Integer sgr_seq;
    private Date g_date;
    private String g_time;
    private String team1;
    private Integer team1_score;
    private Integer team2_score;
    private String team2;
    private String baseball_stadium;
    private String note;
    private String season;

    private String result;
    private String date;
}
