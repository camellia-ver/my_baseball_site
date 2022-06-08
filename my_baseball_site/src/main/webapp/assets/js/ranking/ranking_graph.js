$(function(){
    var rankingChart = new Chart($("#rankingChart"), {
        type:"line",
        options:{
            responsive:false,
        },
        data:{
            labels:null,
            datasets:[{
                label:'순위 변동 그래프',
                data:null,
                backgroundColor:[
                    'rgba(30, 30, 255, 0.7)'
                ]
            }],
        }
    }) 

    function getRankingChart(yaer_or_daily){
        let url = "/ranking/api/graph/" + yaer_or_daily

        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                if(r.data != null) {
                    let rankingChartLabel = new Array();
                    let rankingChartData = new Array();
                    for(let i=0; i<r.data.length; i++) {
                        rankingChartLabel.push(r.data[i].year);
                        rankingChartData.push(r.data[i].no);
                    }
                    rankingChart.data.datasets = new Array(); // 데이터 셋 초기화
                    rankingChart.data.labels = rankingChartLabel; // 레이블 교체
                    rankingChart.data.datasets.push({
                        label:'연도별 총 관중수', data:rankingChartData,
                        backgroundColor:['rgba(30, 30, 255, 0.7)']
                    });
                    rankingChart.update();
                }
            }
        })
    }
})