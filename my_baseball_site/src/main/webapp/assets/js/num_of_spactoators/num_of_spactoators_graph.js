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
})