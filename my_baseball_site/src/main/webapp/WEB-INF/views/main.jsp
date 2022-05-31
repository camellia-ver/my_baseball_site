<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/main.css">
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="contents">
        <div class="content_left">
            <div class="today_game_result">
                <span>5월 27일 삼성 0 VS 5 LG</span>
                <p>패배</p> 
            </div>
            <div class="today_ranking">
                <div class="ranking_title">
                    <h2> < TEAM RANKING > </h2>
                    <button type="button" class="btn btn-primary">더보기</button>
                </div>
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">순위</th>
                        <th scope="col">팀명</th>
                        <th scope="col">게임수</th>
                        <th scope="col">승</th>
                        <th scope="col">패</th>
                        <th scope="col">무</th>
                        <th scope="col">승률</th>
                        <th scope="col">게임차</th>
                        <th scope="col">연속</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${today_ranking}" var="item">
                        <tr>
                          <td>${item.no}</td>
                          <td>${item.team_name}</td>
                          <td>${item.game}</td>
                          <td>${item.win}</td>
                          <td>${item.lose}</td>
                          <td>${item.tie}</td>
                          <td>${item.win_rate}</td>
                          <td>${item.game_difference}</td>
                          <td>${item.continuity}</td>
                        </tr>
                      </c:forEach>
                    </tbody>
                  </table>
            </div>
        </div>
        <div class="content_right">
            <div class="game_schedule">
                <h2>경기 일정</h2>
                <c:forEach items="${three_game_schedule}" var="item">
                    <div class="schedule">
                        <p>${item.date} 경기</p>
                        <p>${item.team1} VS ${item.team2} ${item.baseball_stadium}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
