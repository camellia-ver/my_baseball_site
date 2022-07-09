$(function(){
    let now = new Date()
    let is_baisc = true

    $("#year_select").html("")

    for(let i = now.getFullYear();i >= 1982;i--){
        let tag = '<option value='+i+'>'+i+'</option>'
        $("#year_select").append(tag)
    }

    $("#year_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()

        if(is_baisc && (year < 2002)){
            $(".select_data").css("display","none")
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
        }
        else if(!is_baisc && (year < 2002)){
            alert("2001년 까지의 기록출력")
            $(".select_data").css("display","none")
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
        }
        else{
            alert("2002년 부터의 기록출력")
            if(is_baisc){
                $(".select_data").css("display","block")
                $("#before_2002").css("display","none")
                $("#after_2002").css("display","table")
                $("#detail").css("display","none")
            }
            else{
                $(".select_data").css("display","block")
                $("#before_2002").css("display","none")
                $("#after_2002").css("display","none")
                $("#detail").css("display","table")
            }
        }
    })
    $("#series_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()

        if(year > 2002){
            $("#before_2002").css("display","none")
            $("#after_2002").css("display","table")
            $("#detail").css("display","none")
        }
        else{
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
        }
    })
    $("#position_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()

        if(year > 2002){
            $("#before_2002").css("display","none")
            $("#after_2002").css("display","table")
            $("#detail").css("display","none")
        }
        else{
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
        }
    })

    $("#detail_record").click(function(){
        $("#series_select").attr("disabled",true)
        is_baisc = false
        $("#before_2002").css("display","none")
        $("#after_2002").css("display","none")
        $("#detail").css("display","table")
    })
    $("#basic_record").click(function(){
        let year = $("#year_select").val()
        $("#series_select").attr("disabled",false)
        is_baisc = true
        if(year > 2002){
            $("#before_2002").css("display","none")
            $("#after_2002").css("display","table")
            $("#detail").css("display","none")
        }
        else{
            $("#before_2002").css("display","table")
            $("#after_2002").css("display","none")
            $("#detail").css("display","none")
        }
    })
})