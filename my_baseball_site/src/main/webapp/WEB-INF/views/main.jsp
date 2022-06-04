<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/main.css">
    <script src="/assets/js/main.js"></script>
</head>
<body>
    <div class="contents">
        <div class="content_left">
            <c:if test="${recently_game == null}">
                <div class="today_game_result">
                    <p>올해 시즌 시작 전</p>
                </div>    
            </c:if>
            <c:if test="${recently_game.note != '-'}">
                <div class="today_game_result">
                    <span>${recently_game.date}</span>
                    <p id="game_cancel">${recently_game.note}</p>
                </div>
            </c:if>
            <c:if test="${recently_game.note == '-'}">
                <div class="today_game_result">
                    <span>${recently_game.date} ${recently_game.team1} ${recently_game.team1_score} VS ${recently_game.team2_score} ${recently_game.team2}</span>
                    <p id="game_result">${recently_game.result}</p> 
                </div>
            </c:if>
            <div class="today_ranking">
                <div class="ranking_title">
                    <h2> < TEAM RANKING > </h2>
                    <a class="btn btn-primary" href="/ranking" role="button">더보기</a>
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
                          <td>${item.print_win_rate}</td>
                          <td>${item.print_game_difference}</td>
                          <td>${item.continuity}</td>
                        </tr>
                      </c:forEach>
                    </tbody>
                  </table>
            </div>
        </div>
        <div class="content_right">
            <div class="game_schedule">
                <div class="game_schedule_title">
                    <h2>경기 일정</h2>
                    <a class="btn btn-primary" href="/schedule_game_result" role="button">더보기</a>
                </div>
                <c:forEach items="${three_game_schedule}" var="item">
                    <div class="schedule">
                        <p>${item.date} ${item.g_time} 경기</p>
                        <p>${item.team1} VS ${item.team2} ${item.baseball_stadium}</p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
