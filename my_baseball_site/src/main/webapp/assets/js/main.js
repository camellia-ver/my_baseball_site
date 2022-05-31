$(function(){
    game_result = $("#game_result").text()
    
    if(game_result == "승리")
        $("#game_result").css("color","royalblue")
    else if(game_result == "패배")
        $("#game_result").css("color","crimson")
    else
        $("#game_result").css("color","mediumseagreen")

    game_cancel = $('#game_cancel').text()

    if(game_cancel != '-')
        $("#game_cancel").css("color","mediumpurple")
})