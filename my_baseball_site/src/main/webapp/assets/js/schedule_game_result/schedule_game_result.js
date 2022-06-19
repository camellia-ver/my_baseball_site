$(function(){
    let month_select = "#month_select option:eq("
    let now = new Date()
    let month = now.getMonth()
    let year = 0
   
    month_select += eqFormatting(month) + ")"
    $(month_select).prop("selected",true)

    $("#year_select").change(function(){
        getScheduleGameResult()
    })
    $("#month_select").change(function(){
        getScheduleGameResult()
    })

    $("#left_btn").click(function(){
        let change_year = $("#year_select option:selected").val()
        let change_month = $("#month_select option:selected").val()
        let season = $("#season option:selected").val()

        if(change_year == 2001 && change_month == 1){
            alert("마지막입니다.")
        }
        else if(season == "포스트시즌" && change_year == 2001){
            alert("마지막입니다.")
        }
        else if(season == "포스트시즌"){
            year += 1

            if(year < 0) year = -year

            select_year(year)
            getScheduleGameResult()
        }
        else if(change_month == 1){
            year += 1
            month = 11

            if(year < 0) year = -year

            selected_date(year,month)
            getScheduleGameResult()
        }
        else{
            month -= 1
            month_select = "#month_select option:eq(" + eqFormatting(month) + ')'
            $(month_select).prop("selected",true)

            getScheduleGameResult()
        }
    })
    $("#right_btn").click(function(){
        let change_year = $("#year_select option:selected").val()
        let change_month = $("#month_select option:selected").val()
        let season = $("#season option:selected").val()
        
        if(change_year == now.getFullYear() && change_month == 12){
            alert("마지막입니다.")
        }
        else if(season == "포스트시즌" && change_year == now.getFullYear()){
            alert("마지막입니다.")
        }
        else if(season == "포스트시즌"){
            year -= 1

            if(year < 0) year = -year

            select_year(year)
            getScheduleGameResult()
        }
        else if(change_month == 12){
            year -= 1
            month = 0

            if(year < 0) year = -year
 
            selected_date(year,month)
            getScheduleGameResult()
        }
        else{
            month += 1
            month_select = "#month_select option:eq(" + eqFormatting(month) + ')'
            $(month_select).prop("selected",true)

            getScheduleGameResult()
        }
    })

    $("#season").change(function(){
        let season = $("#season option:selected").val()

        if(season == "포스트시즌"){
            $("#month_select").css("display","none")
            $(".date_select > p").css("display","none")
            getScheduleGameResult()
        }
        else{
            $("#month_select").css("display","block")
            $(".date_select > p").css("display","block")
            getScheduleGameResult()
        }
    })

    function eqFormatting(input_num){
        if(input_num < 10) input_num = '0' + input_num.toString()
        
        return input_num
    }

    function getScheduleGameResult(){
        let change_year = $("#year_select option:selected").val()
        let change_month = $("#month_select option:selected").val()
        let change_season = $("#season option:selected").val()
        let url_month
        let url = "/schedule_game_result/api/list?year=" + change_year

        if(change_season == "포스트시즌")  url_month = ""
        else url_month = change_month
        url += "&month=" + url_month + "&season=" + change_season
        
        month = change_month - 1
        year = change_year - now.getFullYear()
        temp_year = year
        if(year < 0) year = -year

        $("#schedule_game_result_tbody").html("")

        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                let tag
                let print_team1_score
                let print_team2_score
                if(r.data.length == 0){
                    if((temp_year + now.getFullYear()) == 2001){
                        tag = 
                        '<tr><td colspan="6">데이터가 없습니다.</td></tr>'
                        $("#schedule_game_result_tbody").append(tag)
                    }
                    else{
                        tag = 
                        '<tr><td colspan="6">데이터가 없습니다.</td></tr>'
                        $("#schedule_game_result_tbody").append(tag)
                    }
                }
                else{
                    for(let i = 0;i < r.data.length;i++){
                        if(r.data[i].team1_score == -1){
                            print_team1_score = ''
                            print_team2_score = ''
                        }
                        else{
                            print_team1_score = r.data[i].team1_score
                            print_team2_score = r.data[i].team2_score
                        }

                        tag = 
                        '<tr>'+
                            '<td>'+r.data[i].date+'</td>'+
                            '<td>'+r.data[i].g_time+'</td>'+
                            '<td>'+
                                r.data[i].team1+ ' ' + print_team1_score + ' ' +
                                'VS '+
                                print_team2_score + ' '+r.data[i].team2+
                            '</td>'+
                            '<td>'+r.data[i].baseball_stadium+'</td>'+
                            '<td>'+r.data[i].note+'</td>'+
                            '<td>'+r.data[i].season+'</td>'+
                        '</tr>'
                        $("#schedule_game_result_tbody").append(tag)
                    }
                }
            }
        })
    }

    function selected_date(year,month){
        year_select = "#year_select option:eq(" + eqFormatting(year) + ')'
        $(year_select).prop("selected",true)
        month_select = "#month_select option:eq("+ eqFormatting(month) +")"
        $(month_select).prop("selected",true)
    }
    function select_year(year){
        year_select = "#year_select option:eq(" + eqFormatting(year) + ')'
        $(year_select).prop("selected",true)
    }
})