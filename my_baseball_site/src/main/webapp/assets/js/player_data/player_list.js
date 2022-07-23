$(function(){
    $("#select_position").change(function(){
        let position = $("#select_position").val()
        getDataByPosition(position)
    })

    $("#search_btn").click(function(){
        let name = $("#input_form").val()
        getDataByName(name)
    })

    function getDataByPosition(position){
        $("#player_list_tbody").html("")

        let url = "/player_data_by_position/api/"+position

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].backnumber+'</td>'+
                        '<td><a href=\"/detail?name='+r.data[i].name+'&birth='+r.data[i].birth+'\">'+r.data[i].name+'</a></td>'+
                        '<td>'+r.data[i].position1+'</td>'+
                        '<td>'+r.data[i].birth+'</td>'+
                        '<td>'+r.data[i].height+'cm, '+r.data[i].weight+'kg</td>'+
                        '<td>'+r.data[i].career+'</td>'+
                    '</tr>'

                    $("#player_list_tbody").append(tag)
                }
            }
        })
    }
    function getDataByName(name){
        $("#player_list_tbody").html("")

        let url = "/player_data_by_name/api/"+name

        $.ajax({
            type:"get",
            url:url,
            success:function(r){             
                for(let i = 0;i < r.data.length;i++){
                    let tag = 
                    '<tr>'+
                        '<td>'+r.data[i].backnumber+'</td>'+
                        '<td><a href=\"/detail?name='+r.data[i].name+'&birth='+r.data[i].birth+'\">'+r.data[i].name+'</a></td>'+
                        '<td>'+r.data[i].position1+'</td>'+
                        '<td>'+r.data[i].birth+'</td>'+
                        '<td>'+r.data[i].height+'cm, '+r.data[i].weight+'kg</td>'+
                        '<td>'+r.data[i].career+'</td>'+
                    '</tr>'

                    $("#player_list_tbody").append(tag)
                }
            }
        })
    }
})