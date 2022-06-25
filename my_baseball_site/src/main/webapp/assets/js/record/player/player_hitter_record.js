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

        if(!is_baisc && (year < 2002)){
            alert("2001년 까지의 기록출력")
        }
        else{
            alert("2002년 부터의 기록출력")
        }
    })
    $("#series_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()
    })
    $("#position_select").change(function(){
        let year = $("#year_select").val()
        let series = $("#series_select").val()
        let position = $("#position_select").val()
    })

    $("#detail_record").click(function(){
        $("#series_select").attr("disabled",true)
        is_baisc = false
    })
    $("#basic_record").click(function(){
        $("#series_select").attr("disabled",false)
        is_baisc = true
    })
})