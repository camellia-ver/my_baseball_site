package com.my_baseball_site.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NumOfSpactoatorsVO {
    private Integer nos_seq;
    private Date nos_date;
    private String day_of_the_weeks;
    private String home;
    private String away;
    private String baseball_stadium;
    private Integer spactoators;

    private String team_name;
    private String date;
    private String cur_year;
    private String print_spactoators;

    private String nosby_year;

    private String label;
    private Integer avg_spactoators;
}
