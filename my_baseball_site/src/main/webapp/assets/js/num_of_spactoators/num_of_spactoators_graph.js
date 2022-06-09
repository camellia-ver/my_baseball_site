$(function(){
    var spactoatorsChart = new Chart($("#spactoatorsChart"), {
        type:"line",
        options:{
            responsive:false,
        },
        data:{
            labels:null,
            datasets:[{
                label:'홈/방문 별 관중수',
                data:null,
                backgroundColor:[
                    'rgba(30, 30, 255, 0.7)'
                ]
            }],
        }
    })
    var spactoatorsChart2 = new Chart($("#spactoatorsChart2"), {
        type:'doughnut' ,
        options:{
            responsive:false,
        },
        data:{
            labels:null,
            datasets:[{
                label:'홈/방문 별 관중수',
                data:null,
                backgroundColor:[
                    'rgba(30, 30, 255, 0.7)'
                ]
            }],
        }
    })
    
    $("#spactoatorsChart").css("display","none")
    
    getNumOfSpactoatorsInfo("home_away","홈/방문 별")

    $("#data_select").change(function(){
        let data_type = $("#data_select option:selected").val()
        let label
        let title

        if(data_type == "home_away") label = "홈/방문 별"
        if(data_type == "stadium") label = "구장 별"
        if(data_type == "day_of_the_weeks") label = "요일 별"
        if(data_type == "team_home") label = "상대 팀이 홈일 시"
        if(data_type == "team_away") label = "상대 팀이 방문일 시"

        title = label + " 관중수"
        $("#chart_title").html("")
        $("#chart_title").append(title)

        if(data_type == "home_away"){
            $("#spactoatorsChart").css("display","none")
            $("#spactoatorsChart2").css("display","block")
            getNumOfSpactoatorsInfo(data_type,label)
        }
        else{
            $("#spactoatorsChart").css("display","block")
            $("#spactoatorsChart2").css("display","none")
            getNumOfSpactoatorsInfo(data_type,label)
        }
    })

    function getNumOfSpactoatorsInfo(selectData,label){
        let url = "/num_of_spactoators/api/graph/"+selectData

        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                if(selectData == "home_away"){
                    createChart(r,spactoatorsChart2,label)
                }
                else{
                    createChart(r,spactoatorsChart,label)
                }
            }
        })
    }
    function createChart(r,chart,label){
        if(r.data != null) {
            let chartLabel = new Array();
            let chartData = new Array();
            for(let i=0; i<r.data.length; i++) {
                chartLabel.push(r.data[i].label);
                chartData.push(r.data[i].sum_spactoators);
            }
            chart.data.datasets = new Array(); // 데이터 셋 초기화
            chart.data.labels = chartLabel; // 레이블 교체
            chart.data.datasets.push({
                label:label+' 관중수', data:chartData,
                backgroundColor:['rgb(255, 99, 132)','rgb(54, 162, 235)']
            });
            chart.update();
        }
    }
})