<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/ranking.css">
    <!-- <script src="/assets/js/main.js"></script> -->
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>순위</p>
        </div>
        <div class="date_pick">
            <div class="btn_left">
                <button class="btn btn-primary" type="submit"><</button>
            </div>
            <div class="today">
                <p>6월1일</p><br>
                <input type="date" id="input_date">
            </div>
            <div class="btn_right">
                <button class="btn btn-primary" type="submit">></button>
            </div>
        </div>
        <div class="date_select">
            <div class="left_select">
                <div class="select">
                    <select class="form-select" aria-label="Default select example">
                        <!-- <option selected>연도</option> -->
                        <option selected value="1">2022</option>
                        <option value="2">2021</option>
                        <option value="3">2020</option>
                    </select>
                </div>
                <div class="date">
                    <p>6월 1일</p>
                </div>
            </div>
            <div class="right_select">
                <select class="form-select" aria-label="Default select example" id="right_select">
                    <option selected value="정규시즌">정규시즌</option>
                    <option value="포스트시즌">포스트시즌</option>
                </select>
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
                  </tr>
                </thead>
                <tbody>
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
                        <td>${item.continuity}</td>
                        <td>${item.continuity}</td>
                      </tr>
                  <!-- <c:forEach items="${today_ranking}" var="item">
                    
                  </c:forEach> -->
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>