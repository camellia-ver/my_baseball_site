<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/prize/golden_glove.css">
    <!-- <script src="/assets/js/ranking/ranking.js"></script> -->
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>역대 골든글러브</p>
        </div>
        <div class="golden_glove">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">연도</th>
                    <th scope="col">투수</th>
                    <th scope="col">포수</th>
                    <th scope="col">1루수</th>
                    <th scope="col">2루수</th>
                    <th scope="col">3루수</th>
                    <th scope="col">유격수</th>
                    <th scope="col">외야수</th>
                    <th scope="col">지명타자</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach items="${golden_glove}" var="item">
                        <tr>
                            <td>${item.gg_year}</td>
                            <td>${item.gg_P_name} - ${item.gg_P_team}</td>
                            <td>${item.gg_C_name} - ${item.gg_C_team}</td>
                            <td>${item.gg_1B_name} - ${item.gg_1B_team}</td>
                            <td>${item.gg_2B_name} - ${item.gg_2B_team}</td>
                            <td>${item.gg_3B_name} - ${item.gg_3B_team}</td>
                            <td>${item.gg_SS_name} - ${item.gg_SS_team}</td>
                            <td>
                                ${item.gg_OF_name1} - ${item.gg_OF_team1}<br>
                                ${item.gg_OF_name2} - ${item.gg_OF_team2}<br>
                                ${item.gg_OF_name3} - ${item.gg_OF_team3}<br>
                                <c:if test="${item.gg_OF_name4 != ''}">
                                    ${item.gg_OF_name4} - ${item.gg_OF_team4}
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${item.gg_DH_name != ''}">
                                    ${item.gg_DH_name} - ${item.gg_DH_team}
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>