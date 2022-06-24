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
            $("#team_pitcher_record_tbody").html("")
        }
        else{
            $("#regular_serise").css("display","none")
            $("#other_serise").css("display","table")
            $("#other_serise_tbody").html("")
        }

        $.ajax({
            type:"get",
            url:"/team_pitcher_record/api/list?year="+year+"&series="+series,
            success:function(r){
                let tag
                if(r.data.length == 0 && series == "정규시즌"){
                    tag = '<tr><td colspan="31">데이터가 없습니다.</td></tr>'
                    $("#team_pitcher_record_tbody").append(tag)
                }
                else if(r.data.length == 0){
                    tag = '<tr><td colspan="19">데이터가 없습니다.</td></tr>'
                    $("#other_serise_tbody").append(tag)
                }
                else{
                    for(let i = 0;i < r.data.length;i++){
                        if(series == "정규시즌"){
                            tag = 
                                '<tr>'+
                                    '<td>'+r.data[i].tpr_team_name+'</td>'+
                                    '<td>'+r.data[i].print_era+'</td>'+
                                    '<td>'+r.data[i].tpr_G+'</td>'+
                                    '<td>'+r.data[i].tpr_W+'</td>'+
                                    '<td>'+r.data[i].tpr_L+'</td>'+
                                    '<td>'+r.data[i].tpr_SV+'</td>'+
                                    '<td>'+r.data[i].tpr_HLD+'</td>'+
                                    '<td>'+r.data[i].print_wptc+'</td>'+
                                    '<td>'+r.data[i].tpr_IP+'</td>'+
                                    '<td>'+r.data[i].tpr_H+'</td>'+
                                    '<td>'+r.data[i].tpr_HR+'</td>'+
                                    '<td>'+r.data[i].tpr_BB+'</td>'+
                                    '<td>'+r.data[i].tpr_HBP+'</td>'+
                                    '<td>'+r.data[i].tpr_SO+'</td>'+
                                    '<td>'+r.data[i].tpr_R+'</td>'+
                                    '<td>'+r.data[i].tpr_ER+'</td>'+
                                    '<td>'+r.data[i].print_whip+'</td>'+
                                    '<td>'+r.data[i].tpr_CG+'</td>'+
                                    '<td>'+r.data[i].tpr_SHO+'</td>'+
                                    '<td>'+r.data[i].tpr_QS+'</td>'+
                                    '<td>'+r.data[i].tpr_BSV+'</td>'+
                                    '<td>'+r.data[i].tpr_TBF+'</td>'+
                                    '<td>'+r.data[i].tpr_NP+'</td>'+
                                    '<td>'+r.data[i].print_avg+'</td>'+
                                    '<td>'+r.data[i].tpr_2B+'</td>'+
                                    '<td>'+r.data[i].tpr_3B+'</td>'+
                                    '<td>'+r.data[i].tpr_SAC+'</td>'+
                                    '<td>'+r.data[i].tpr_SF+'</td>'+
                                    '<td>'+r.data[i].tpr_IBB+'</td>'+
                                    '<td>'+r.data[i].tpr_WP+'</td>'+
                                    '<td>'+r.data[i].tpr_BK+'</td>'+
                                '</tr>'
    
                            $("#team_pitcher_record_tbody").append(tag)
                        }
                        else{
                            tag = 
                                '<tr>'+
                                    '<td>'+r.data[i].tpr_team_name+'</td>'+
                                    '<td>'+r.data[i].print_era+'</td>'+
                                    '<td>'+r.data[i].tpr_G+'</td>'+
                                    '<td>'+r.data[i].tpr_CG+'</td>'+
                                    '<td>'+r.data[i].tpr_SHO+'</td>'+
                                    '<td>'+r.data[i].tpr_W+'</td>'+
                                    '<td>'+r.data[i].tpr_L+'</td>'+
                                    '<td>'+r.data[i].tpr_SV+'</td>'+
                                    '<td>'+r.data[i].tpr_HLD+'</td>'+
                                    '<td>'+r.data[i].print_wptc+'</td>'+
                                    '<td>'+r.data[i].tpr_TBF+'</td>'+
                                    '<td>'+r.data[i].tpr_IP+'</td>'+
                                    '<td>'+r.data[i].tpr_H+'</td>'+
                                    '<td>'+r.data[i].tpr_HR+'</td>'+
                                    '<td>'+r.data[i].tpr_BB+'</td>'+
                                    '<td>'+r.data[i].tpr_HBP+'</td>'+
                                    '<td>'+r.data[i].tpr_SO+'</td>'+
                                    '<td>'+r.data[i].tpr_R+'</td>'+
                                    '<td>'+r.data[i].tpr_ER+'</td>'+
                                '</tr>'
    
                            $("#other_serise_tbody").append(tag)
                        }
                    }
                }
            }
        })
    }
})