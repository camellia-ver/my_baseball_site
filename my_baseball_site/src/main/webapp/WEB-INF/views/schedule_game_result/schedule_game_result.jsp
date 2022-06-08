<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>baseball data site</title>
        <link rel="stylesheet" href="/assets/css/schedule_game_result/schedule_game_result.css">
        <script src="/assets/js/schedule_game_result/schedule_game_result.js"></script>
    </head>
    <body>
        <div class="contents">
            <div class="title">
                <p>경기 일정/결과</p>
            </div>
            <div class="date_div">
                <div class="btn_left">
                    <button class="btn btn-primary" id="left_btn"><</button>
                </div>
                <div class="date_select">
                    <select class="form-select" aria-label="Default select example" id="year_select">
                        <c:forEach items="${years}" var="item">
                            <option value="${item}">${item}</option>
                        </c:forEach>
                    </select><p>년</p>
                    <select class="form-select" aria-label="Default select example" id="month_select">
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select><p>월</p>
                </div>
                <div class="btn_right">
                    <button class="btn btn-primary" id="right_btn">></button>
                </div>
            </div>
            <div class="schedule_game_result">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">일자</th>
                        <th scope="col">시간</th>
                        <th scope="col">시합</th>
                        <th scope="col">구장</th>
                        <th scope="col">참고사항</th>
                        <th scope="col">시즌</th>
                      </tr>
                    </thead>
                    <tbody id="schedule_game_result_tbody">
                        <c:if test="${cur_data == null}">
                            <tr colspan="6">
                                <td>데이터가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${cur_data}" var="item">
                            <tr>
                                <td>${item.date}</td>
                                <td>${item.g_time}</td>
                                <td>
                                    ${item.team1} 
                                    <c:if test="${item.team1_score != -1}">${item.team1_score}</c:if> 
                                    VS 
                                    <c:if test="${item.team2_score != -1}">${item.team2_score}</c:if>
                                     ${item.team2}
                                </td>
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
