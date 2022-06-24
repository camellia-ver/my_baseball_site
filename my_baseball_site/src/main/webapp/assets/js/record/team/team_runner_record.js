$(function(){
    $("#series_select").attr("disabled",true)

    $("#year_select").change(function(){
        let year = $("#year_select option:selected").val()
        getTeamDefenseRecord(year)
    })

    function getTeamDefenseRecord(year){
        $("#team_runner_record_tbody").html("")

        $.ajax({
            type:"get",
            url:"/team_runner_record/api/"+year,
            success:function(r){
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].trr_team_name+'</td>'+
                        '<td>'+r.data[i].trr_G+'</td>'+
                        '<td>'+r.data[i].trr_SBA+'</td>'+
                        '<td>'+r.data[i].trr_SB+'</td>'+
                        '<td>'+r.data[i].trr_SB_PERSENT+'</td>'+
                        '<td>'+r.data[i].trr_CS+'</td>'+
                        '<td>'+r.data[i].trr_OOB+'</td>'+
                        '<td>'+r.data[i].trr_PKO+'</td>'+
                    '</tr>'

                    $("#team_runner_record_tbody").append(tag)
                }
            }
        })
    }
})