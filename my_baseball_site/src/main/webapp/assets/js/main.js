$(function(){
    game_result = $("#game_result").text()
    
    if(game_result == "승리")
        $("#game_result").css("color","royalblue")
    else
        $("#game_result").css("color","salmon")
})