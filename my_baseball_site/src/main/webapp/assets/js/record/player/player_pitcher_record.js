$(function(){
    let now = new Date()
    let is_baisc = true

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
        
        if(series != "정규시즌"){
            $(".select_data").css("display","none")
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
            before2002(year,series,position)
        }
        else{
            $(".select_data").css("display","block")
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

        let url = "/player_pitcher_record/api/basic?year="+year+"&series="+series+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 

                    $("#before_2002_tdody").append(tag)
                }
            }
        })
    }
    function after2002(year,series,position){
        $("#after_2002_tdody").html("")

        let url = "/player_pitcher_record/api/basic?year="+year+"&series="+series+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].pprb_player_name+'</td>'+
                        '<td>'+r.data[i].pprb_ERA+'</td>'+
                        '<td>'+r.data[i].pprb_G+'</td>'+
                        '<td>'+r.data[i].pprb_CG+'</td>'+
                        '<td>'+r.data[i].pprb_SHO+'</td>'+
                        '<td>'+r.data[i].pprb_W+'</td>'+
                        '<td>'+r.data[i].pprb_L+'</td>'+
                        '<td>'+r.data[i].pprb_SV+'</td>'+
                        '<td>'+r.data[i].pprb_HLD+'</td>'+
                        '<td>'+r.data[i].print_wpct+'</td>'+
                        '<td>'+r.data[i].pprb_TBF+'</td>'+
                        '<td>'+r.data[i].pprb_IP+'</td>'+
                        '<td>'+r.data[i].pprb_H+'</td>'+
                        '<td>'+r.data[i].pprb_HR+'</td>'+
                        '<td>'+r.data[i].pprb_BB+'</td>'+
                        '<td>'+r.data[i].pprb_HBP+'</td>'+
                        '<td>'+r.data[i].pprb_SO+'</td>'+
                        '<td>'+r.data[i].pprb_R+'</td>'+
                        '<td>'+r.data[i].pprb_ER+'</td>'+
                    '</tr>'

                    $("#after_2002_tdody").append(tag)
                }
            }
        })
    }
    function detail(year,position){
        $("#detail_tdody").html("")

        let url = "/player_pitcher_record/api/detail?year="+year+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    

                    $("#detail_tdody").append(tag)
                }
            }
        })
    }
})