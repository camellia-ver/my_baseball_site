<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>baseball data site</title>
        <link rel="stylesheet" href="/assets/css/num_of_spactoators_year.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.0/dist/chart.min.js"></script>
        <script src="/assets/js/num_of_spactoators/num_of_spactoators_year.js"></script>
    </head>
    <body>
        <div class="contents">
            <%@include file="/WEB-INF/views/includes/num_of_spactoators_title.jsp"%>
            <div class="num_of_spactoators">
                <div class="sum_year_area">
                    <h1>연도별 총 관중수</h1>
                    <canvas id="sumYearChart" style="width:100%; height:100%;"></canvas>
                </div>
                <div class="avg_one_game_area">
                    <h1>연도별 한경기 당 평균 관중수</h1>
                    <canvas id="avgOneGameChart" style="width:100%; height:100%;"></canvas>
                </div>
            </div>
        </div>
    </body>
</html>