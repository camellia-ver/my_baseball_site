<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/team_runner_record.css">
    <script src="/assets/js/record/team_runner_record.js"></script>
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
        </div>
        <div class="team_runner_record">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">팀명</th>
                    <th scope="col">G</th>
                    <th scope="col">SBA</th>
                    <th scope="col">SB</th>
                    <th scope="col">SB%</th>
                    <th scope="col">CS</th>
                    <th scope="col">OOB</th>
                    <th scope="col">PKO</th>
                  </tr>
                </thead>
                <tbody id="team_runner_record_tbody">
                    <c:forEach items="${runner}" var="item">
                        <tr>
                            <td>${item.trr_team_name}</td>
                            <td>${item.trr_G}</td>
                            <td>${item.trr_SBA}</td>
                            <td>${item.trr_SB}</td>
                            <td>${item.trr_SB_PERSENT}</td>
                            <td>${item.trr_CS}</td>
                            <td>${item.trr_OOB}</td>
                            <td>${item.trr_PKO}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>