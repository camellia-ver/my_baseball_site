$(function(){
    let game_result = $("#game_result").text()
    if(game_result == "승리")
        $("#game_result").css("color","royalblue")
    else if(game_result == "패배")
        $("#game_result").css("color","crimson")
    else
        $("#game_result").css("color","mediumseagreen")

    let game_cancel = $('#game_cancel').text()
    if(game_cancel != '-')
        $("#game_cancel").css("color","mediumpurple")

    let not_game = $('#not_game').text()
    if(not_game = "경기없음"){
        let now = new Date()
        let today = printDate(now)

        $(".today_game_result > span").text(today)
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
})