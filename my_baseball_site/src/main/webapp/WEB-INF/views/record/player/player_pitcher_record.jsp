<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/player/player_pitcher_record.css">
    <script src="/assets/js/record/player/player_pitcher_record.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/player_record_title.jsp"%>
    <div class="contents">
        <div class="player_pitcher_record">
            <table class="table table-striped" id="after_2002">
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
                <tbody id="after_2002_tdody">
                    <c:forEach items="${runner}" var="item">
                        <tr>
                            <td>${item.prr_player_name}</td>
                            <td>${item.prr_G}</td>
                            <td>${item.prr_SBA}</td>
                            <td>${item.prr_SB}</td>
                            <td>${item.print_sb_persent}</td>
                            <td>${item.prr_CS}</td>
                            <td>${item.prr_OOB}</td>
                            <td>${item.prr_PKO}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <table class="table table-striped" id="before_2002">
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
                <tbody id="before_2002_tdody">
                    <c:forEach items="${runner}" var="item">
                        <tr>
                            <td>${item.prr_player_name}</td>
                            <td>${item.prr_G}</td>
                            <td>${item.prr_SBA}</td>
                            <td>${item.prr_SB}</td>
                            <td>${item.print_sb_persent}</td>
                            <td>${item.prr_CS}</td>
                            <td>${item.prr_OOB}</td>
                            <td>${item.prr_PKO}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <table class="table table-striped" id="detail">
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
                <tbody id="detail_tdody">
                    <c:forEach items="${runner}" var="item">
                        <tr>
                            <td>${item.prr_player_name}</td>
                            <td>${item.prr_G}</td>
                            <td>${item.prr_SBA}</td>
                            <td>${item.prr_SB}</td>
                            <td>${item.print_sb_persent}</td>
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