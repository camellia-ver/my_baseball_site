$(function(){
    $(".select").change(function(){
        year = $(".select option:selected").val()
        var now = new Date()

        if(year == 2022)
        {
            today = now.getFullYear().toString() 
            
            if(now.getMonth() < 10) today += "0" + now.getMonth().toString()
            else today += now.getMonth().toString()
            if(now.getDate() < 10) today += "0" + now.getDate().toString()
            else today += now.getDate().toString()

            alert(today)
        }
        else if(year == 1999 || year == 2000)
        {
            // 양대리그
            alert(year)
        }
        else
        {
            $("#ranking_tbody").html("");
        }
    })
})