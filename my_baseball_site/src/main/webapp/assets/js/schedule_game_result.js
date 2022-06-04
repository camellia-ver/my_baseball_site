$(function(){
    let month_select = "#month_select option:eq("
    let now = new Date()

    month_select += monthFormatting(now) + ")"
    $(month_select).prop("selected",true)

    function monthFormatting(now){
        let retun_month = now.getMonth()

        if(retun_month < 10) retun_month = '0' + retun_month.toString()
        
        return retun_month
    }
})