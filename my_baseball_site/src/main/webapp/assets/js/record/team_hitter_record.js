$(function(){
    $("#year_select").change(function(){
        let year = $("#year_select option:selected").val()
        let series = $("#series_select option:selected").val()

        getTeamHitterRecord(year,series)
    })
    $("#series_select").change(function(){
        let year = $("#year_select option:selected").val()
        let series = $("#series_select option:selected").val()
        let now = new Date()

        $("#year_select").html("")

        if(series == "정규시즌"){
            for(let i = now.getFullYear();i >= 2001;i--){
                let tag = '<option value='+i+'>'+i+'</option>'
                $("#year_select").append(tag)
            }
        }
        else{
            for(let i = now.getFullYear();i >= 1982;i--){
                let tag = '<option value='+i+'>'+i+'</option>'
                $("#year_select").append(tag)
            }
        }

        let year_select = "#year_select option:eq("
        year_select += eqFormatting(year-now.getFullYear()) + ")"
        $(year_select).prop("selected",true)

        getTeamHitterRecord(year,series)
    })

    function eqFormatting(input_num){
        if(input_num < 0) input_num = -input_num
        if(input_num < 10) input_num = '0' + input_num.toString()
        
        return input_num
    }

    function getTeamHitterRecord(year,series){
        if(series == "정규시즌"){
            $("#regular_serise").css("display","table")
            $("#other_serise").css("display","none")
            $("#team_hitter_record_tbody").html("")
        }
        else{
            $("#regular_serise").css("display","none")
            $("#other_serise").css("display","table")
            $("#other_serise_tbody").html("")
        }

        $.ajax({
            type:"get",
            url:"/team_hitter_record/api/list?year="+year+"&series="+series,
            success:function(r){
                let tag
                if(r.data.length == 0 && series == "정규시즌"){
                    tag = '<tr><td colspan="25">데이터가 없습니다.</td></tr>'
                    $("#team_hitter_record_tbody").append(tag)
                }
                else if(r.data.length == 0){
                    tag = '<tr><td colspan="18">데이터가 없습니다.</td></tr>'
                    $("#other_serise_tbody").append(tag)
                }
                else{
                    for(let i = 0;i < r.data.length;i++){
                        if(series == "정규시즌"){
                            tag = 
                                '<tr>'+
                                    '<td>'+r.data[i].thr_team_name+'</td>'+
                                    '<td>'+r.data[i].print_avg+'</td>'+
                                    '<td>'+r.data[i].thr_G+'</td>'+
                                    '<td>'+r.data[i].thr_PA+'</td>'+
                                    '<td>'+r.data[i].thr_AB+'</td>'+
                                    '<td>'+r.data[i].thr_R+'</td>'+
                                    '<td>'+r.data[i].thr_H+'</td>'+
                                    '<td>'+r.data[i].thr_2B+'</td>'+
                                    '<td>'+r.data[i].thr_3B+'</td>'+
                                    '<td>'+r.data[i].thr_HR+'</td>'+
                                    '<td>'+r.data[i].thr_TB+'</td>'+
                                    '<td>'+r.data[i].thr_RBI+'</td>'+
                                    '<td>'+r.data[i].thr_SAC+'</td>'+
                                    '<td>'+r.data[i].thr_SF+'</td>'+
                                    '<td>'+r.data[i].thr_BB+'</td>'+
                                    '<td>'+r.data[i].thr_IBB+'</td>'+
                                    '<td>'+r.data[i].thr_HBP+'</td>'+
                                    '<td>'+r.data[i].thr_SO+'</td>'+
                                    '<td>'+r.data[i].thr_GDP+'</td>'+
                                    '<td>'+r.data[i].print_slg+'</td>'+
                                    '<td>'+r.data[i].print_obp+'</td>'+
                                    '<td>'+r.data[i].print_ops+'</td>'+
                                    '<td>'+r.data[i].thr_MH+'</td>'+
                                    '<td>'+r.data[i].print_risp+'</td>'+
                                    '<td>'+r.data[i].print_ph_ba+'</td>'+
                                '</tr>'
    
                            $("#team_hitter_record_tbody").append(tag)
                        }
                        else{
                            tag = 
                                '<tr>'+
                                    '<td>'+r.data[i].thr_team_name+'</td>'+
                                    '<td>'+r.data[i].print_avg+'</td>'+
                                    '<td>'+r.data[i].thr_G+'</td>'+
                                    '<td>'+r.data[i].thr_AB+'</td>'+
                                    '<td>'+r.data[i].thr_R+'</td>'+
                                    '<td>'+r.data[i].thr_H+'</td>'+
                                    '<td>'+r.data[i].thr_2B+'</td>'+
                                    '<td>'+r.data[i].thr_3B+'</td>'+
                                    '<td>'+r.data[i].thr_HR+'</td>'+
                                    '<td>'+r.data[i].thr_TB+'</td>'+
                                    '<td>'+r.data[i].thr_RBI+'</td>'+
                                    '<td>'+r.data[i].thr_SB+'</td>'+
                                    '<td>'+r.data[i].thr_CS+'</td>'+
                                    '<td>'+r.data[i].thr_BB+'</td>'+
                                    '<td>'+r.data[i].thr_HBP+'</td>'+
                                    '<td>'+r.data[i].thr_SO+'</td>'+
                                    '<td>'+r.data[i].thr_GDP+'</td>'+
                                    '<td>'+r.data[i].thr_E+'</td>'+
                                '</tr>'
    
                            $("#other_serise_tbody").append(tag)
                        }
                    }
                }
            }
        })
    }
})