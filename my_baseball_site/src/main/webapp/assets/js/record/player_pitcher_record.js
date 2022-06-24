$(function(){
    let now = new Date()

    $("#position_select").attr("disabled",true)

    $("#year_select").html("")
    
    for(let i = now.getFullYear();i >= 1982;i--){
        let tag = '<option value='+i+'>'+i+'</option>'
        $("#year_select").append(tag)
    }
})