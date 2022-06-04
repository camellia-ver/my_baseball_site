<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>baseball data site</title>
        <link rel="stylesheet" href="/assets/css/schedule_game_result.css">
        <!-- <script src="/assets/js/main.js"></script> -->
    </head>
    <body>
        <div class="contents">
            <div class="title">
                <p>순위</p>
            </div>
            <div class="date_div">
                <div class="btn_left">
                    <button class="btn btn-primary" type="submit" id="left_btn"><</button>
                </div>
                <div class="date_select">
                    <select class="form-select" aria-label="Default select example" id="year_select">
                        <option value=1>1</option>
                    </select>
                    <select class="form-select" aria-label="Default select example" id="month_select">
                        <option value=1>1</option>
                    </select>
                </div>
                <div class="btn_right">
                    <button class="btn btn-primary" type="submit" id="right_btn">></button>
                </div>
            </div>
            <div class="schedule_game_result">
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
                      </tr>
                    </thead>
                    <tbody id="ranking_tbody">
                            <tr>
                                <td>${item.no}</td>
                                <td>${item.team_name}</td>
                                <td>${item.game}</td>
                                <td>${item.win}</td>
                                <td>${item.lose}</td>
                                <td>${item.tie}</td>
                                <td>${item.print_win_rate}</td>
                                <td>${item.print_game_difference}</td>
                            </tr>
                    </tbody>
                  </table>
            </div>
        </div>
    </body>
</html>
