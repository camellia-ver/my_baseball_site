$(function(){
    let now = new Date()

    $(".select_data").css("display","none")

    $("#series_select").attr("disabled",true)

    $("#year_select").html("")

    for(let i = now.getFullYear();i >= 2001;i--){
        let tag = '<option value='+i+'>'+i+'</option>'
        $("#year_select").append(tag)
    }
})