<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/team_pitcher_record.css">
    <script src="/assets/js/record/team_pitcher_record.js"></script>
</head>
<body>
    <div class="contents">
        <%@include file="/WEB-INF/views/includes/team_record_title.jsp"%>
        <div class="search_option">
            <select class="form-select" aria-label="Default select example" id="year_select">
                <c:forEach items="${regular_serise_year}" var="item">
                        <option value=${item}>${item}</option>
                </c:forEach>
            </select>
            <select class="form-select" aria-label="Default select example" id="series_select">
                <option value="정규시리즈" selected>정규시리즈</option>
                <option value="와일드카드">와일드카드</option>
                <option value="준플레이오프">준플레이오프</option>
                <option value="플레이오프">플레이오프</option>
                <option value="한국시리즈">한국시리즈</option>
            </select>
        </div>
    </div>
</body>
</html>