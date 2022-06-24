$(function(){
    let btn_now = new Date()
    let btn_today = createToday(btn_now)
    let btn_date = btn_now
    let btn_url = btn_today

    $("#left_btn").click(function(){
        btn_event(-1)
    })
    $("#right_btn").click(function(){
        btn_event(1)
    })

    $("#input_date").change(function(){
        let input_date = $("#input_date").val()
        $("#input_date").val(input_date)
        let dateArr = input_date.split("-")
        let date = dateArr[0] + dateArr[1] + dateArr[2]
        let print_today = dateArr[0] +"년 " + dateArr[1]+"월 " + dateArr[2]+"일"
        let print_date = dateArr[1]+"월 " + dateArr[2]+"일"

        btn_date = new Date(btn_date.setFullYear(dateArr[0]))
        btn_date = new Date(btn_date.setMonth(parseInt(dateArr[1])-1))
        btn_date = new Date(btn_date.setDate(dateArr[2]))

        btn_url = createToday(btn_date)

        $("#print_today").html("")
        $("#print_today").append(print_today)
        $("#print_date").html("")
        $("#print_date").append(print_date)
        getRegister(date)
    })

    function createToday(now){
        let today = now.getFullYear().toString() 
            
        if(now.getMonth() < 10) today += "0" + (now.getMonth() + 1).toString()
        else today += now.getMonth().toString()
        
        if(now.getDate() < 10) today += "0" + now.getDate().toString()
        else today += now.getDate().toString()

        return today
    }
    function createInputDateFormat(now){
        let today = now.getFullYear().toString() 
            
        if(now.getMonth() < 10) today += "-" +  "0" + (now.getMonth() + 1).toString()
        else today += "-" + now.getMonth().toString()
        
        if(now.getDate() < 10) today += "-" +  "0" + now.getDate().toString()
        else today += "-" + now.getDate().toString()

        return today
    }
    function printDate(now){
        let print_date
        if(now.getMonth() < 10) 
            print_date = "0" + (now.getMonth() + 1).toString() + "월 " 
        else 
            print_date = now.getMonth().toString() + "월 " 
        
        if(now.getDate() < 10) 
            print_date += "0" + now.getDate().toString() + "일"
        else 
            print_date += now.getDate().toString() + "일"

        return print_date
    }
    function printToday(now){
        let print_date = 
            now.getFullYear().toString() + "년 "
        
        if(now.getMonth() < 10) 
            print_date += "0" + (now.getMonth() + 1).toString() + "월 " 
        else 
            print_date += now.getMonth().toString() + "월 " 
        
        if(now.getDate() < 10) 
            print_date += "0" + now.getDate().toString() + "일"
        else 
            print_date += now.getDate().toString() + "일"

        return print_date
    }
    function btn_event(minus_or_plus_day){
        btn_date = new Date(btn_date.setDate(btn_date.getDate() + minus_or_plus_day))
        btn_url = createToday(btn_date)

        $("#print_today").html("")
        $("#print_today").append(printToday(btn_date))
        $("#print_date").html("")
        $("#print_date").append(printDate(btn_date))

        $("#input_date").val(createInputDateFormat(btn_date))

        getRegister(btn_url)
    }
    function getRegister(date){
        $("#register_manager_tbody").html("")
        $("#register_coach_tbody").html("")
        $("#register_p_tbody").html("")
        $("#register_c_tbody").html("")
        $("#register_if_tbody").html("")
        $("#register_of_tbody").html("")
        $("#regist_tbody").html("")
        $("#register_out_tbody").html("")

        let url = "/register/api/"+date

        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                let tag = '<tr><td colspan="5">데이터가 없습니다.</td></tr>'
                let regist_count = 0
                let out_register_count = 0
                if(r.data.length == 0){
                    $("#register_manager_tbody").append(tag)
                    $("#register_coach_tbody").append(tag)
                    $("#register_p_tbody").append(tag)
                    $("#register_c_tbody").append(tag)
                    $("#register_if_tbody").append(tag)
                    $("#register_of_tbody").append(tag)
                    $("#regist_tbody").append(tag)
                    $("#register_out_tbody").append(tag)
                }
                else{
                    for(let i = 0;i < r.data.length;i++){
                        let tag2 =
                            '<tr>'+
                                '<td>'+r.data[i].rg_back_number+'</td>'+
                                '<td>'+r.data[i].rg_name+'</td>'+
                                '<td>'+r.data[i].rg_p_b_type+'</td>'+
                                '<td>'+r.data[i].print_brith+'</td>'+
                                '<td>'+r.data[i].rg_height+'cm,'+r.data[i].rg_weight+'kg</td>'+
                            '</tr>'

                        if(r.data[i].rg_position == "감독" && r.data[i].is_regist == "")
                            $("#register_manager_tbody").append(tag2)
                        else if(r.data[i].rg_position == "코치" && r.data[i].is_regist == "")
                            $("#register_coach_tbody").append(tag2)
                        else if(r.data[i].rg_position == "투수" && r.data[i].is_regist == "")
                            $("#register_p_tbody").append(tag2)
                        else if(r.data[i].rg_position == "포수" && r.data[i].is_regist == "")
                            $("#register_c_tbody").append(tag2)
                        else if(r.data[i].rg_position == "내야수" && r.data[i].is_regist == "")
                            $("#register_if_tbody").append(tag2)
                        else if(r.data[i].rg_position == "외야수" && r.data[i].is_regist == "")
                            $("#register_of_tbody").append(tag2)
                        else if(r.data[i].is_regist == "등록"){
                            regist_count += 1
                            $("#regist_tbody").append(tag2)
                        } 
                        else if(r.data[i].is_regist == "말소"){
                            out_register_count += 1
                            $("#register_out_tbody").append(tag2)
                        }
                    }

                    if(regist_count == 0){
                        $("#regist_tbody").html("")
                        $("#regist_tbody").append(tag)
                    }
                    if(out_register_count == 0){
                        $("#register_out_tbody").html("")
                        $("#register_out_tbody").append(tag)
                    }
                }
            }
        })
    }
})