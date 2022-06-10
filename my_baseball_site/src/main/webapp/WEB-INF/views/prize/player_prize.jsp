<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/prize/player_prize.css">
    <!-- <script src="/assets/js/ranking/ranking.js"></script> -->
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>역대 개인수상</p>
        </div>
        <div class="player_prize">
            <table class="table table-striped">
                <thead>
                    <tr>
                      <th scope="col">연도</th>
                      <th scope="col">KBO MVP</th>
                      <th scope="col">KBO 신인상</th>
                      <th scope="col">KBO 올스타전 MVP</th>
                      <th scope="col">KBO 한국시리즈 MVP</th>
                    </tr>
                  </thead>
                <tbody>
                    <c:forEach items="${player_prize}" var="item">
                        <tr>
                            <td>${item.pp_year}</td>
                            <td>${item.kbo_mvp_name}
                                <c:if test="${item.kbo_mvp_name != '해당자 없음'}">
                                    (${item.kbo_mvp_team},${item.kbo_mvp_position})
                                </c:if>
                            </td>
                            <td>${item.kbo_new_man_name}
                                <c:if test="${item.kbo_new_man_name != '해당자 없음'}">
                                    (${item.kbo_new_man_team},${item.kbo_new_man_position})
                                </c:if>
                            </td>
                            <td>${item.kbo_all_star_mvp_name}
                                <c:if test="${item.kbo_all_star_mvp_name != '해당자 없음'}">
                                    (${item.kbo_all_star_mvp_team},${item.kbo_all_star_mvp_position})
                                </c:if>
                            </td>
                            <td>${item.kbo_korea_series_mvp_name}
                                <c:if test="${item.kbo_korea_series_mvp_name != '해당자 없음'}">
                                    (${item.kbo_korea_series_mvp_team},${item.kbo_korea_series_mvp_position})
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