<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/team_defense_record.css">
    <script src="/assets/js/record/team_defense_record.js"></script>
</head>
<body>
    <div class="contents">
        <%@include file="/WEB-INF/views/includes/team_record_title.jsp"%>
        <div class="search_option">
            <select class="form-select" aria-label="Default select example" id="year_select">
                <option value="2022" selected>2022</option>
            </select>
        </div>
    </div>
</body>
</html>