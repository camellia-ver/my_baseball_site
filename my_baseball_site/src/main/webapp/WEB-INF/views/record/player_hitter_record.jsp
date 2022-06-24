<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/player_hitter_record.css">
    <script src="/assets/js/record/player_hitter_record.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/player_record_title.jsp"%>
    <div class="contents">
        <div class="select_data">
            <a href="/player_hitter_record">기본기록</a>
            <a href="/player_hitter_record_detail">세부기록</a>
        </div>
    </div>
</body>
</html>