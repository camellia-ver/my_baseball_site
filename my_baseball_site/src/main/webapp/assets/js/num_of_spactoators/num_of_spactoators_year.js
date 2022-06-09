$(function(){
    var sumYearChart = new Chart($("#sumYearChart"), {
        type:"line",
        options:{
            responsive:false,
        },
        data:{
            labels:null,
            datasets:[{
                label:'연도별 총 관중수',
                data:null,
                backgroundColor:[
                    'rgba(30, 30, 255, 0.7)'
                ]
            }],
        }
    })  
    var avgOneGameChart = new Chart($("#avgOneGameChart"), {
        type:"line",
        options:{
            responsive:false,
        },
        data:{
            labels:null,
            datasets:[{
                label:'연도별 한 경기 당 평균 관중수',
                data:null,
                backgroundColor:[
                    'rgba(255, 30, 30, 0.7)'
                ]
            }],
        }
    })

    getNumOfSpactoatorsInfo("sum_year")
    getNumOfSpactoatorsInfo("avg_one_game")

    function getNumOfSpactoatorsInfo(selectData){
        let url = "/num_of_spactoators/api/year/"+selectData
        
        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                if(selectData == "sum_year"){
                    createChart(r,sumYearChart,"연도별 총",'rgba(30, 30, 255, 0.7)')
                }
                else{
                    createChart(r,avgOneGameChart,"연도별 한 경기 당 평균",'rgba(225, 30, 30, 0.7)')
                } 
            }
        })
    }
    function createChart(r,chart,label,color){
        if(r.data != null) {
            let chartLabel = new Array();
            let chartData = new Array();
            for(let i=0; i<r.data.length; i++) {
                chartLabel.push(r.data[i].nosby_year);
                chartData.push(r.data[i].spactoators);
            }
            chart.data.datasets = new Array(); // 데이터 셋 초기화
            chart.data.labels = chartLabel; // 레이블 교체
            chart.data.datasets.push({
                label:label+' 관중수', data:chartData,
                backgroundColor:[color]
            });
            chart.update();
        }
    }
})