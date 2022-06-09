<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.8.0/dist/chart.min.js"></script>
    <link rel="stylesheet" href="/assets/css/ranking/ranking_graph.css">
    <script src="/assets/js/ranking/ranking_graph.js"></script>
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>순위변동 그래프</p>
        </div>
        <div class="select">
            <select class="form-select" aria-label="Default select example" id="isYearDaily">
                <option value="일자" selected>일자/연도</option>
                <option value="일자">일자</option>
                <option value="연도">연도</option>
            </select>
            <div class="date_select">
                <p>비교분석 구간 지정</p>
                <input type="date" min="${start_date}" max="${end_date}" value="${start_date}" id="start_date">  
                <p>~</p> 
                <input type="date" min="${start_date}" max="${end_date}" value="${end_date}" id="end_date">
                <p>최대 30일까지 가능</p>
                <button class="btn btn-primary" type="submit" id="search_btn">검색</button>
            </div>
        </div>
        <div class="ranking_graph">
            <div class="graph_area">
                <h1 id="graph_title">일자별 순위 변동</h1>
                <canvas id="rankingChart" style="width:100%; height:100%;"></canvas>
            </div>
        </div>
    </div>
</body>
</html>