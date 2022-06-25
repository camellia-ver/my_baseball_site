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

        getPlayerRunnerRecord(year,position)
    })
    $("#position_select").change(function(){
        let year = $("#year_select").val()
        let position = $("#position_select").val()

        getPlayerRunnerRecord(year,position)
    })

    function getPlayerRunnerRecord(year,position){
        $("#player_runner_record_tdody").html("")

        let url = "/player_runner_record/api/list?year="+year+"&position="+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){   
                console.log(r) 
                let sb_persent          
                for(let i = 0;i < r.data.length;i++){                    
                    if(r.data[i].print_sb_persent == '-1.0') sb_persent = '-'
                    else sb_persent = r.data[i].print_sb_persent

                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].prr_player_name+'</td>'+
                        '<td>'+r.data[i].prr_G+'</td>'+
                        '<td>'+r.data[i].prr_SBA+'</td>'+
                        '<td>'+r.data[i].prr_SB+'</td>'+
                        '<td>'+sb_persent+'</td>'+
                        '<td>'+r.data[i].prr_CS+'</td>'+
                        '<td>'+r.data[i].prr_OOB+'</td>'+
                        '<td>'+r.data[i].prr_PKO+'</td>'+
                    '</tr>'
                    console.log(tag)
                    $("#player_runner_record_tdody").append(tag)
                }
            }
        })
    }
})