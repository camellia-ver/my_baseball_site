$(function(){
    $(".select").change(function(){
        year = $(".select option:selected").val()
        alert(year)
    })
})