<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/player/player_runner_record.css">
    <script src="/assets/js/record/player/player_runner_record.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/player_record_title.jsp"%>
    <div class="contents">
        <div class="player_runner_record">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">이름</th>
                    <th scope="col">G</th>
                    <th scope="col">SBA</th>
                    <th scope="col">SB</th>
                    <th scope="col">SB%</th>
                    <th scope="col">CS</th>
                    <th scope="col">OOB</th>
                    <th scope="col">PKO</th>
                  </tr>
                </thead>
                <tbody id="player_runner_record_tdody">
                    <c:forEach items="${runner}" var="item">
                        <tr>
                            <td>${item.prr_player_name}</td>
                            <td>${item.prr_G}</td>
                            <td>${item.prr_SBA}</td>
                            <td>${item.prr_SB}</td>
                            <c:if test="${item.print_sb_persent != '-1.0'}">
                                <td>${item.print_sb_persent}</td>
                            </c:if>
                            <c:if test="${item.print_sb_persent == '-1.0'}">
                                <td>-</td>
                            </c:if>
                            <td>${item.prr_CS}</td>
                            <td>${item.prr_OOB}</td>
                            <td>${item.prr_PKO}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>