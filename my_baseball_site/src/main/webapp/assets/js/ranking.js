$(function(){
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
        let dateArr = input_date.split("-")
        let date = dateArr[0] + dateArr[1] + dateArr[2]
        let print_today = dateArr[0] +"년 " + dateArr[1]+"월 " + dateArr[2]+"일"
        let print_date = dateArr[1]+"월 " + dateArr[2]+"일"

        $("#print_today").html("")
        $("#print_today").append(print_today)
        $("#print_date").html("")
        $("#print_date").append(print_date)
        getRanking(date)
    })

    $("#left_btn").click(function(){
        alert("이전")
    })
    $("#right_btn").click(function(){
        alert("이후")
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
        $("#ranking_tbody").html("");

        $.ajax({
            type:"get",
            url:"/ranking/"+date,
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
                    $("#ranking_tbody").append(tag);
                }
            }
        })
    }
})