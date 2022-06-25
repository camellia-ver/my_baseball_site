<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/player/player_defense_record.css">
    <script src="/assets/js/record/player/player_defense_record.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/player_record_title.jsp"%>
    <div class="contents">
        <div class="player_defense_record">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">이름</th>
                    <th scope="col">POS</th>
                    <th scope="col">G</th>
                    <th scope="col">GS</th>
                    <th scope="col">IP</th>
                    <th scope="col">E</th>
                    <th scope="col">PKO</th>
                    <th scope="col">PO</th>
                    <th scope="col">A</th>
                    <th scope="col">DP</th>
                    <th scope="col">FPCT</th>
                    <th scope="col">PB</th>
                    <th scope="col">SB</th>
                    <th scope="col">CS</th>
                    <th scope="col">CS%</th>
                  </tr>
                </thead>
                <tbody id="player_defense_record_tbody">
                    <c:forEach items="${defense}" var="item">
                        <tr>
                            <td>${item.pdr_player_name}</td>
                            <td>${item.pdr_position}</td>
                            <td>${item.pdr_G}</td>
                            <td>${item.pdr_GS}</td>
                            <td>${item.pdr_IP}</td>
                            <td>${item.pdr_E}</td>
                            <td>${item.pdr_PKO}</td>
                            <td>${item.pdr_PO}</td>
                            <td>${item.pdr_A}</td>
                            <td>${item.pdr_DP}</td>
                            <c:if test="${item.print_fpct != '-1.000'}">
                                <td>${item.print_fpct}</td>
                            </c:if>
                            <c:if test="${item.print_fpct == '-1.000'}">
                                <td>-</td>
                            </c:if>
                            <td>${item.pdr_PB}</td>
                            <td>${item.pdr_SB}</td>
                            <td>${item.pdr_CS}</td>
                            <c:if test="${item.print_cs_persent != '-1.0'}">
                                <td>${item.print_cs_persent}</td>
                            </c:if>
                            <c:if test="${item.print_cs_persent == '-1.0'}">
                                <td>-</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>