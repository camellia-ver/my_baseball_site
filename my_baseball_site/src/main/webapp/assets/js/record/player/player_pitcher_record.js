$(function(){
    let now = new Date()
    let is_baisc = true

    $("#position_select").attr("disabled",true)

    $("#year_select").html("")

    for(let i = now.getFullYear();i >= 1982;i--){
        let tag = '<option value='+i+'>'+i+'</option>'
        $("#year_select").append(tag)
    }

    $("#year_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()

        if(year < 2002){
            $(".select_data").css("display","none")
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
            before2002(year,series,position)
        }
        else{
            if(is_baisc){
                $(".select_data").css("display","block")
                $("#before_2002").css("display","none")
                $("#after_2002").css("display","table")
                $("#detail").css("display","none")
                after2002(year,series,position)
            }
            else{
                $(".select_data").css("display","block")
                $("#before_2002").css("display","none")
                $("#after_2002").css("display","none")
                $("#detail").css("display","table")
                detail(year,position)
            }
        }
    })
    $("#series_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()

        if(year > 2002){
            $("#before_2002").css("display","none")
            $("#after_2002").css("display","table")
            $("#detail").css("display","none")
            after2002(year,series,position)
        }
        else{
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
            before2002(year,series,position)
        }
    })
    $("#position_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()

        if(year > 2002){
            $("#before_2002").css("display","none")
            $("#after_2002").css("display","table")
            $("#detail").css("display","none")
            after2002(year,series,position)
        }
        else{
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
            before2002(year,series,position)
        }
    })

    $("#detail_record").click(function(){
        let year = $("#year_select").val()
        let position = $("#position_select").val()
        
        $("#series_select").attr("disabled",true)
        is_baisc = false
        $("#before_2002").css("display","none")
        $("#after_2002").css("display","none")
        $("#detail").css("display","table")
        detail(year,position)
    })
    $("#basic_record").click(function(){
        let year = $("#year_select").val()
        $("#series_select").attr("disabled",false)
        is_baisc = true
        if(year > 2002){
            $("#before_2002").css("display","none")
            $("#after_2002").css("display","table")
            $("#detail").css("display","none")
            after2002(year,series,position)
        }
        else{
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
            before2002(year,series,position)
        }
    })

    function before2002(year,series,position){
        $("#before_2002_tdody").html("")

        let url = "/player_hitter_record/api/basic?year="+year+"&series="+series+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].phrb_player_name+'</td>'+
                        '<td>'+r.data[i].print_avg+'</td>'+
                        '<td>'+r.data[i].phrb_G+'</td>'+
                        '<td>'+r.data[i].phrb_PA+'</td>'+
                        '<td>'+r.data[i].phrb_AB+'</td>'+
                        '<td>'+r.data[i].phrb_H+'</td>'+
                        '<td>'+r.data[i].phrb_2B+'</td>'+
                        '<td>'+r.data[i].phrb_3B+'</td>'+
                        '<td>'+r.data[i].phrb_HR+'</td>'+
                        '<td>'+r.data[i].phrb_RBI+'</td>'+
                        '<td>'+r.data[i].phrb_SB+'</td>'+
                        '<td>'+r.data[i].phrb_CS+'</td>'+
                        '<td>'+r.data[i].phrb_BB+'</td>'+
                        '<td>'+r.data[i].phrb_HBP+'</td>'+
                        '<td>'+r.data[i].phrb_SO+'</td>'+
                        '<td>'+r.data[i].phrb_GDP+'</td>'+
                        '<td>'+r.data[i].phrb_E+'</td>'+
                    '</tr>'

                    $("#before_2002_tdody").append(tag)
                }
            }
        })
    }
    function after2002(year,series,position){
        $("#after_2002_tdody").html("")

        let url = "/player_hitter_record/api/basic?year="+year+"&series="+series+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        +'<td>'+r.data[i].phrb_player_name+'</td>'
                        +'<td>'+r.data[i].print_avg+'</td>'
                        +'<td>'+r.data[i].phrb_G+'</td>'
                        +'<td>'+r.data[i].phrb_PA+'</td>'
                        +'<td>'+r.data[i].phrb_AB+'</td>'
                        +'<td>'+r.data[i].phrb_R+'</td>'
                        +'<td>'+r.data[i].phrb_H+'</td>'
                        +'<td>'+r.data[i].phrb_2B+'</td>'
                        +'<td>'+r.data[i].phrb_3B+'</td>'
                        +'<td>'+r.data[i].phrb_HR+'</td>'
                        +'<td>'+r.data[i].phrb_TB+'</td>'
                        +'<td>'+r.data[i].phrb_RBI+'</td>'
                        +'<td>'+r.data[i].phrb_SAC+'</td>'
                        +'<td>'+r.data[i].phrb_SF+'</td>'
                        +'<td>'+r.data[i].phrb_BB+'</td>'
                        +'<td>'+r.data[i].phrb_IBB+'</td>'
                        +'<td>'+r.data[i].phrb_HBP+'</td>'
                        +'<td>'+r.data[i].phrb_SO+'</td>'
                        +'<td>'+r.data[i].phrb_GDP+'</td>'
                        +'<td>'+r.data[i].print_slg+'</td>'
                        +'<td>'+r.data[i].print_obp+'</td>'
                        +'<td>'+r.data[i].print_ops+'</td>'
                        +'<td>'+r.data[i].phrb_MH+'</td>'
                        +'<td>'+r.data[i].print_risp+'</td>'
                        +'<td>'+r.data[i].print_ph_ba+'</td>'
                    '</tr>'

                    $("#after_2002_tdody").append(tag)
                }
            }
        })
    }
    function detail(year,position){
        $("#detail_tdody").html("")

        let url = "/player_hitter_record/api/detail?year="+year+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].phrd_player_name+'</td>'+
                        '<td>'+r.data[i].phrd_XBH+'</td>'+
                        '<td>'+r.data[i].phrd_GO+'</td>'+
                        '<td>'+r.data[i].phrd_AO+'</td>'+
                        '<td>'+r.data[i].print_go_ao+'</td>'+
                        '<td>'+r.data[i].phrd_GW_RBI+'</td>'+
                        '<td>'+r.data[i].print_bb_k+'</td>'+
                        '<td>'+r.data[i].print_p_pa+'</td>'+
                        '<td>'+r.data[i].print_isop+'</td>'+
                        '<td>'+r.data[i].print_xr+'</td>'+
                        '<td>'+r.data[i].print_gpa+'</td>'+
                    '</tr>'

                    $("#detail_tdody").append(tag)
                }
            }
        })
    }
})