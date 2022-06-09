<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>baseball data site</title>
        <link rel="stylesheet" href="/assets/css/num_of_spactoators/num_of_spactoators_graph.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.8.0/dist/chart.min.js"></script>
        <script src="/assets/js/num_of_spactoators/num_of_spactoators_graph.js"></script>
    </head>
    <body>
        <div class="contents">
            <%@include file="/WEB-INF/views/includes/num_of_spactoators_title.jsp"%>
            <div class="select_area">
                <select class="form-select" aria-label="Default select example" id="content_select">
                    <option value="" selected>확인할 데이터 선택</option>
                    <option value="home_away">홈/방문</option>
                    <option value="stadium">구장</option>
                    <option value="day_of_the_weeks">요일</option>
                    <option value="team">상대 팀</option>
                </select>
            </div>
            <div class="num_of_spactoators">
                <div class="spactoators_chart_area">
                    <h1 id="chart_title">홈/방문 별 관중수</h1>
                    <canvas id="spactoatorsChart" style="width:100%; height:100%;"></canvas>
                </div>
            </div>
        </div>
    </body>
</html>