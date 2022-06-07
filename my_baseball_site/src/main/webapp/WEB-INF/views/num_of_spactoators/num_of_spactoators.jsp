<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>baseball data site</title>
        <link rel="stylesheet" href="/assets/css/num_of_spactoators.css">
        <!-- <script src="/assets/js/ranking.js"></script> -->
    </head>
    <body>
        <div class="contents">
            <div class="title">
                <p>관중현황</p>
            </div>
            <div class="select_area">
                <p>검색항목</p>
                <select class="form-select" aria-label="Default select example" id="year_select">
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" id="month_select">
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" id="home_away_select">
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" id="stadium_select">
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" id="day_of_week_select">
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-primary" type="submit">검색</button>
            </div>
            <div class="num_of_spactoators">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">날짜</th>
                        <th scope="col">요일</th>
                        <th scope="col">홈</th>
                        <th scope="col">방문</th>
                        <th scope="col">구장</th>
                        <th scope="col">관중수</th>
                      </tr>
                    </thead>
                    <tbody id="schedule_game_result_tbody">
                        <c:forEach items="${cur_data}" var="item">
                            <tr>
                                <td>${item.date}</td>
                                <td>${item.g_time}</td>
                                <td></td>
                                <td>${item.baseball_stadium}</td>
                                <td>${item.note}</td>
                                <td>${item.season}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>