$(function(){
    let now = new Date()

    $(".select_data").css("display","none")

    $("#series_select").attr("disabled",true)

    $("#year_select").html("")

    for(let i = now.getFullYear();i >= 2001;i--){
        let tag = '<option value='+i+'>'+i+'</option>'
        $("#year_select").append(tag)
    }

    $("#year_select").change(function(){
        let year = $("#year_select").val()
        let position = $("#position_select").val()

        getPlayerDefenseRecord(year,position)
    })
    $("#position_select").change(function(){
        let year = $("#year_select").val()
        let position = $("#position_select").val()

        getPlayerDefenseRecord(year,position)
    })

    function getPlayerDefenseRecord(year,position){
        $("#player_defense_record_tbody").html("")

        let url = "/player_defense_record/api/list?year="+year+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){    
                let fpct 
                let cs_persent          
                for(let i = 0;i < r.data.length;i++){
                    if(r.data[i].print_fpct == '-1.000') fpct = '-'
                    else fpct = r.data[i].print_fpct
                    
                    if(r.data[i].print_cs_persent == '-1.0') cs_persent = '-'
                    else cs_persent = r.data[i].print_cs_persent

                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].pdr_player_name+'</td>'+
                        '<td>'+r.data[i].pdr_position+'</td>'+
                        '<td>'+r.data[i].pdr_G+'</td>'+
                        '<td>'+r.data[i].pdr_GS+'</td>'+
                        '<td>'+r.data[i].pdr_IP+'</td>'+
                        '<td>'+r.data[i].pdr_E+'</td>'+
                        '<td>'+r.data[i].pdr_PKO+'</td>'+
                        '<td>'+r.data[i].pdr_PO+'</td>'+
                        '<td>'+r.data[i].pdr_A+'</td>'+
                        '<td>'+r.data[i].pdr_DP+'</td>'+
                        '<td>'+fpct+'</td>'+
                        '<td>'+r.data[i].pdr_PB+'</td>'+
                        '<td>'+r.data[i].pdr_SB+'</td>'+
                        '<td>'+r.data[i].pdr_CS+'</td>'+
                        '<td>'+cs_persent+'</td>'+
                    '</tr>'

                    $("#player_defense_record_tbody").append(tag)
                }
            }
        })
    }
})