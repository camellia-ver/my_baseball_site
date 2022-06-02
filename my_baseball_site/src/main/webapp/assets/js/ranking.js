$(function(){
    $(".select").change(function(){
        let year = $(".select option:selected").val()
        let now = new Date()

        if(year == now.getFullYear.toString())
        {
            let today = createToday(now)

            alert(today)
            $(".btn_left").append('<button class="btn btn-primary" type="submit"><</button>')
            $(".btn_right").append('<button class="btn btn-primary" type="submit">></button>')
        }
        else if(year == 1999 || year == 2000)
        {
            // 양대리그
            alert(year)
        }
        else
        {
            $(".btn_left").html("")
            $(".btn_right").html("")
            $("#ranking_tbody").html("");
        }
    })

    $("#input_date").change(function(){
        let now = new Date()
        let input_date = $("#input_date").val()
        let dateArr = input_date.split("-")
        let date = dateArr[0] + dateArr[1] + dateArr[2]
        let today = createToday(now)
        alert(today)
    })

    function createToday(now){
        let today = now.getFullYear().toString() 
            
        if(now.getMonth() < 10) today += "0" + now.getMonth().toString()
        else today += now.getMonth().toString()
        
        if(now.getDate() < 10) today += "0" + now.getDate().toString()
        else today += now.getDate().toString()

        return today
    }
})