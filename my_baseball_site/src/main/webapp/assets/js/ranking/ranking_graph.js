$(function(){
    var rankingChart = new Chart($("#rankingChart"), {
        type:"line",
        options:{
            responsive:false,
            scales: {
                y: {
                    reverse: true,
                }
            }
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

    $("#isYearDaily").change(function(){
        let year_or_daily = $("#isYearDaily option:selected").val()
        
        getRankingChart(year_or_daily)
    })
    $("#search_btn").click(function(){
        getRankingChart("일자")
    })

    getRankingChart("일자")

    function getRankingChart(year_or_daily){
        let url = "/ranking/api/graph?year_or_daily=" + year_or_daily
        let label = year_or_daily + "별 순위변동"
        let start_date
        let end_date

        $("#graph_title").html("")
        $("#graph_title").append(label)

        if(year_or_daily == "일자"){
            $(".date_select").css("display","inline-flex")
            start_date = $("#start_date").val()
            end_date = $("#end_date").val()
        }
        else{
            $(".date_select ").css("display","none")
            start_date = ""
            end_date = ""
        }
        url += "&start_date=" + start_date + "&end_date=" + end_date
        
        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                if(r.data != null) {
                    let rankingChartLabel = new Array();
                    let rankingChartData = new Array();
                    for(let i=0; i<r.data.length; i++) {
                        if(year_or_daily == "일자") rankingChartLabel.push(r.data[i].print_date);
                        else rankingChartLabel.push(r.data[i].year);
                        rankingChartData.push(r.data[i].no);
                    }
                    rankingChart.data.datasets = new Array(); // 데이터 셋 초기화
                    rankingChart.data.labels = rankingChartLabel; // 레이블 교체
                    rankingChart.data.datasets.push({
                        label:label, data:rankingChartData,
                        backgroundColor:['rgba(30, 30, 255, 0.7)']
                    });
                    rankingChart.update();
                }
            }
        })
    }
})