<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/ranking/ranking.css">
    <script src="/assets/js/ranking/ranking.js"></script>
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>순위</p>
        </div>
        <div class="date_pick">
            <div class="btn_left">
                <button class="btn btn-primary" type="submit" id="left_btn"><</button>
            </div>
            <div class="today">
                <p id="print_today">${today_ranking[0].print_full_date}</p><br>
                <input type="date" id="input_date" min=${startDate} max=${today_ranking[0].max_date} value=${today_ranking[0].max_date}>
            </div>
            <div class="btn_right">
                <button class="btn btn-primary" type="submit" id="right_btn">></button>
            </div>
        </div>
        <div class="date_select">
            <div class="select">
                <select class="form-select" aria-label="Default select example" id="select">
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="date">
                <p id="print_date">${today_ranking[0].print_date}</p>
            </div>
        </div>
        <div class="ranking">
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
                    <th scope="col">최근 10경기</th>
                    <th scope="col">연속</th>
                    <th scope="col">홈</th>
                    <th scope="col">방문</th>
                    <th scope="col">리그</th>
                  </tr>
                </thead>
                <tbody id="ranking_tbody">
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
                            <td>${item.last_10_matches}</td>
                            <td>${item.continuity}</td>
                            <td>${item.home}</td>
                            <td>${item.away}</td>
                            <td>${item.uniqueness}</td>
                        </tr>
                    </c:forEach>
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>