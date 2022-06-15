<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>baseball data site</title>
        <link rel="stylesheet" href="/assets/css/num_of_spactoators/num_of_spactoators.css">
        <script src="/assets/js/num_of_spactoators/num_of_spactoators.js"></script>
    </head>
    <body>
        <div class="contents">
            <%@include file="/WEB-INF/views/includes/num_of_spactoators_title.jsp"%>
            <div class="select_area">
                <p>검색항목</p>
                <select class="form-select" aria-label="Default select example" id="year_select">
                    <option value=${num_of_spactoators[0].cur_year} selected>시즌별</option>
                    <c:forEach items="${years}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" id="month_select">
                    <option value="0" selected>월별</option>
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
                <select class="form-select" aria-label="Default select example" id="team_select">
                    <option value="0" selected>상대팀별</option>
                    <c:forEach items="${teams}" var="item">
                        <option value=${item}>${item}</option>
                    </c:forEach>
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
                    <tbody id="num_of_spactoators_tbody">
                        <c:if test="${num_of_spactoators == null}">
                            <tr colspan="6">
                                <td>데이터가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${num_of_spactoators}" var="item">
                            <tr>
                                <td>${item.date}</td>
                                <td>${item.day_of_the_weeks}</td>
                                <td>${item.home}</td>
                                <td>${item.away}</td>
                                <td>${item.baseball_stadium}</td>
                                <td>${item.print_spactoators}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>