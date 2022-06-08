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
        let url = "/num_of_spactoators/year/api/"+selectData
        
        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                if(selectData == "sum_year"){
                    if(r.data != null) {
                        let Label = new Array();
                        let Data = new Array();
                        for(let i=0; i<r.data.length; i++) {
                            Label.push(r.data[i].nosby_year);
                            Data.push(r.data[i].sum_year);
                        }
                        sumYearChart.data.datasets = new Array(); // 데이터 셋 초기화
                        sumYearChart.data.labels = Label; // 레이블 교체
                        sumYearChart.data.datasets.push({
                            label:'연도별 총 관중수', data:Data,
                            backgroundColor:['rgba(30, 30, 255, 0.7)']
                        });
                        sumYearChart.update();
                    }
                }
                else{
                    if(r.data != null) {
                        let Label = new Array();
                        let Data = new Array();
                        for(let i=0; i<r.data.length; i++) {
                            Label.push(r.data[i].nosby_year);
                            Data.push(r.data[i].avg_one_game);
                        }
                        avgOneGameChart.data.datasets = new Array(); // 데이터 셋 초기화
                        avgOneGameChart.data.labels = Label; // 레이블 교체
                        avgOneGameChart.data.datasets.push({
                            label:'연도별 한 경기 당 평균 관중수', data:Data,
                            backgroundColor:['rgba(225, 30, 30, 0.7)']
                        });
                        avgOneGameChart.update();
                    }
                }
                
            }
        })
    }

})