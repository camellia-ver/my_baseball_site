$(function(){
    $("#select_area_btn").click(function(){
        getNumOfSpactoators()
    })

    function getNumOfSpactoators(){
        let year = $("#year_select option:selected").val()
        let month = $("#month_select option:selected").val()
        let home_away = $("#home_away_select option:selected").val()
        let stadium = $("#stadium_select option:selected").val()
        let day_of_week = $("#day_of_week_select option:selected").val()

        url = "/num_of_spactoators/api/list?year=" + year + "&month=" + month
        if(home_away == '0') home_away = ""
        url += "&home_away=" + home_away
        if(stadium == '0') stadium = ""
        url += "&stadium=" + stadium
        if(day_of_week == '0') day_of_week = ""
        url += "&day_of_week=" + day_of_week
        
        $("#num_of_spactoators_tbody").html("")

        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                if(r.data.length == 0){
                    tag = 
                    '<tr>'+
                        '<td colspan="6">데이터가 없습니다.</td>'+
                    '</tr>'

                    $("#num_of_spactoators_tbody").append(tag)
                }
                else{
                    for(let i = 0;i < r.data.length;i++){
                        let tag = 
                        '<tr>'+
                            '<td>'+r.data[i].date+'</td>'+
                            '<td>'+r.data[i].day_of_the_weeks+'</td>'+
                            '<td>'+r.data[i].home+'</td>'+
                            '<td>'+r.data[i].away+'</td>'+
                            '<td>'+r.data[i].baseball_stadium+'</td>'+
                            '<td>'+r.data[i].spactoators+'</td>'+
                        '</tr>'
                        $("#num_of_spactoators_tbody").append(tag)
                    }
                }
            }
        })
    }
})