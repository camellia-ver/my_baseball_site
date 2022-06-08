<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>baseball data site</title>
        <link rel="stylesheet" href="/assets/css/num_of_spactoators_graph.css">
        <!-- <script src="/assets/js/num_of_spactoators_graph.js"></script> -->
    </head>
    <body>
        <div class="contents">
            <div class="title">
                <p>관중현황</p>
            </div>
            <div class="select_table_graph">
                <a class="btn btn-primary" href="/num_of_spactoators" role="button">일자별 관중현황</a>
                <a class="btn btn-primary" href="/num_of_spactoators/graph" role="button">관중현황 그래프</a>
            </div>
            <div class="select_area">
                <p>검색항목</p>
                <select class="form-select" aria-label="Default select example" id="year_select">
                    <option value=${num_of_spactoators[0].cur_year} selected>시즌별</option>
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" id="month_select">
                    <option value=${num_of_spactoators[0].cur_month} selected>월별</option>
                    <option value="03">03월</option>
                    <option value="04">04월</option>
                    <option value="05">05월</option>
                    <option value="06">06월</option>
                    <option value="07">07월</option>
                    <option value="08">08월</option>
                    <option value="09">09월</option>
                    <option value="10">10월</option>
                    <option value="11">11월</option>
                    <option value="12">12월</option>
                </select>
                <select class="form-select" aria-label="Default select example" id="home_away_select">
                    <option value="0" selected>홈/방문별</option>
                    <option value="home">홈</option>
                    <option value="away">방문</option>
                </select>
                <select class="form-select" aria-label="Default select example" id="stadium_select">
                    <option value="0" selected>구장별</option>
                    <c:forEach items="${baseball_stadiums}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" id="day_of_week_select">
                    <option value="0" selected>요일</option>
                    <option value="화">화</option>
                    <option value="수">수</option>
                    <option value="목">목</option>
                    <option value="금">금</option>
                    <option value="토">토</option>
                    <option value="일">일</option>
                    <option value="월">월</option>
                </select>
                <button class="btn btn-primary" type="submit" id="select_area_btn">검색</button>
            </div>
            <div class="num_of_spactoators">
                
            </div>
        </div>
    </body>
</html>