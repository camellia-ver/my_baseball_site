$(function(){
    let btn_now = new Date()
    let btn_today = createToday(btn_now)
    let btn_date = btn_now
    let btn_url = btn_today

    $(".select").change(function(){
        let year = $(".select option:selected").val()
        let now = new Date()
        let cur_year = now.getFullYear().toString() 

        if(year == cur_year)
        {
            let today = createToday(now)
            let print_today = printToday(now)
            let print_date = printDate(now)

            $(".btn_left").append('<button class="btn btn-primary" type="submit"><</button>')
            $(".btn_right").append('<button class="btn btn-primary" type="submit">></button>')
            $("#input_date").css("display","block")
            $("#print_today").html("")
            $("#print_today").append(print_today)
            $("#print_date").html("")
            $("#print_date").append(print_date)
            
            getRanking(today)
        }
        else if(year == 1999 || year == 2000) // 양대리그
        {
            let date = year + "1231"

            $(".btn_left").html("")
            $(".btn_right").html("")
            $("#input_date").css("display","none")
            $("#print_today").html("")
            $("#print_date").html("")

            getRanking(date)   
        }
        else
        {
            let date = year + "1231"

            $(".btn_left").html("")
            $(".btn_right").html("")
            $("#input_date").css("display","none")
            $("#print_today").html("")
            $("#print_date").html("")
            
            getRanking(date)
        }
    })

    $("#input_date").change(function(){
        let input_date = $("#input_date").val()
        $("#input_date").val(input_date)
        let dateArr = input_date.split("-")
        let date = dateArr[0] + dateArr[1] + dateArr[2]
        let print_today = dateArr[0] +"년 " + dateArr[1]+"월 " + dateArr[2]+"일"
        let print_date = dateArr[1]+"월 " + dateArr[2]+"일"

        btn_date = new Date(btn_date.setFullYear(dateArr[0]))
        btn_date = new Date(btn_date.setMonth(parseInt(dateArr[1])-1))
        btn_date = new Date(btn_date.setDate(dateArr[2]))

        btn_url = createToday(btn_date)

        $("#print_today").html("")
        $("#print_today").append(print_today)
        $("#print_date").html("")
        $("#print_date").append(print_date)
        getRanking(date)
    })

    $("#left_btn").click(function(){
        let start_date = $("#input_date").attr("min")
        let startDateArr = start_date.split("-")
        start_date = startDateArr[0] + startDateArr[1] + startDateArr[2]
        
        if(btn_url == start_date)
            alert("마지막 날짜 입니다.")
        else{
            btn_event(-1)
        }
    })
    $("#right_btn").click(function(){
        let end_date = $("#input_date").attr("max")
        let endDateArr = end_date.split("-")
        end_date = endDateArr[0] + endDateArr[1] + endDateArr[2]
        
        if(btn_url == end_date)
            alert("마지막 날짜 입니다.")
        else
        {
            btn_event(1)
        }
    })

    function createToday(now){
        let today = now.getFullYear().toString() 
            
        if(now.getMonth() < 10) today += "0" + (now.getMonth() + 1).toString()
        else today += now.getMonth().toString()
        
        if(now.getDate() < 10) today += "0" + now.getDate().toString()
        else today += now.getDate().toString()

        return today
    }
    function printToday(now){
        let print_date = 
            now.getFullYear().toString() + "년 "
        
        if(now.getMonth() < 10) 
            print_date += "0" + (now.getMonth() + 1).toString() + "월 " 
        else 
            print_date += now.getMonth().toString() + "월 " 
        
        if(now.getDate() < 10) 
            print_date += "0" + now.getDate().toString() + "일"
        else 
            print_date += now.getDate().toString() + "일"

        return print_date
    }
    function printDate(now){
        let print_date
        if(now.getMonth() < 10) 
            print_date = "0" + (now.getMonth() + 1).toString() + "월 " 
        else 
            print_date = now.getMonth().toString() + "월 " 
        
        if(now.getDate() < 10) 
            print_date += "0" + now.getDate().toString() + "일"
        else 
            print_date += now.getDate().toString() + "일"

        return print_date
    }

    function getRanking(date){
        $("#ranking_tbody").html("")

        $.ajax({
            type:"get",
            url:"/ranking/api/"+date,
            success:function(r){
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].no+'</td>'+
                        '<td>'+r.data[i].team_name+'</td>'+
                        '<td>'+r.data[i].game+'</td>'+
                        '<td>'+r.data[i].win+'</td>'+
                        '<td>'+r.data[i].lose+'</td>'+
                        '<td>'+r.data[i].tie+'</td>'+
                        '<td>'+r.data[i].print_win_rate+'</td>'+
                        '<td>'+r.data[i].print_game_difference+'</td>'+
                        '<td>'+r.data[i].last_10_matches+'</td>'+
                        '<td>'+r.data[i].continuity+'</td>'+
                        '<td>'+r.data[i].home+'</td>'+
                        '<td>'+r.data[i].away+'</td>'+
                        '<td>'+r.data[i].uniqueness+'</td>'+
                    '</tr>'
                    $("#ranking_tbody").append(tag)
                }
            }
        })
    }

    function btn_event(minus_or_plus_day){
        btn_date = new Date(btn_date.setDate(btn_date.getDate() + minus_or_plus_day))
        btn_url = createToday(btn_date)
        
        $("#print_today").html("")
        $("#print_today").append(printToday(btn_date))
        $("#print_date").html("")
        $("#print_date").append(printDate(btn_date))

        getRanking(btn_url)
    }
})