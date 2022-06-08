<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/ranking/ranking_graph.css">
    <script src="/assets/js/ranking/ranking_graph.js"></script>
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>순위변동 그래프</p>
        </div>
        <div class="select">
            <select class="form-select" aria-label="Default select example" id="isCurYear">
                <option value="0" selected>일자/연도</option>
                <option value="1">일자</option>
                <option value="2">연도</option>
            </select>
        </div>
        <div class="ranking_graph">
            <div class="graph_area">
                <h1 id="graph_title">순위</h1>
                <canvas id="rankingChart" style="width:100%; height:100%;"></canvas>
            </div>
        </div>
    </div>
</body>
</html>