<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/player_runner_record.css">
    <script src="/assets/js/record/player_runner_record.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/player_record_title.jsp"%>
    <div class="contents">
        <div class="search_option">
            <select class="form-select" aria-label="Default select example" id="year_select">
                <c:forEach items="${regular_serise_year}" var="item">
                        <option value=${item}>${item}</option>
                </c:forEach>
            </select>
            <select class="form-select" aria-label="Default select example" id="series_position">
                <option value="전체" selected>전체</option>
                <option value="포수">포수</option>
                <option value="내야수">내야수</option>
                <option value="외야수">외야수</option>
            </select>
        </div>
    </div>
</body>
</html>