package com.my_baseball_site.vo;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterVO {
    private Integer rg_seq;    
    private Integer rg_back_number;
    private String rg_name;
    private String rg_p_b_type;
    private Date rg_brith;
    private String rg_height;
    private String rg_weight;
    private Date rg_date;
    private String rg_position;
    private String is_regist;

    private String print_brith;
    private String print_date;
    private String max_date;
}
