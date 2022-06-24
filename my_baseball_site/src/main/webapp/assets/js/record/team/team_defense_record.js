$(function(){
    $("#series_select").attr("disabled",true)

    $("#year_select").change(function(){
        let year = $("#year_select option:selected").val()
        getTeamDefenseRecord(year)
    })

    function getTeamDefenseRecord(year){
        $("#team_defense_record_tbody").html("")

        $.ajax({
            type:"get",
            url:"/team_defense_record/api/"+year,
            success:function(r){
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].tdr_team_name+'</td>'+
                        '<td>'+r.data[i].tdr_G+'</td>'+
                        '<td>'+r.data[i].tdr_E+'</td>'+
                        '<td>'+r.data[i].tdr_PKO+'</td>'+
                        '<td>'+r.data[i].tdr_PO+'</td>'+
                        '<td>'+r.data[i].tdr_A+'</td>'+
                        '<td>'+r.data[i].tdr_DP+'</td>'+
                        '<td>'+r.data[i].print_fpct+'</td>'+
                        '<td>'+r.data[i].tdr_PB+'</td>'+
                        '<td>'+r.data[i].tdr_SB+'</td>'+
                        '<td>'+r.data[i].tdr_CS+'</td>'+
                        '<td>'+r.data[i].tdr_CS_PERSENT+'</td>'+
                    '</tr>'

                    $("#team_defense_record_tbody").append(tag)
                }
            }
        })
    }
})