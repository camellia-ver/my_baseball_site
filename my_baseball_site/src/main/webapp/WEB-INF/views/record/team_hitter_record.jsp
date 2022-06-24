<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/team_hitter_record.css">
    <script src="/assets/js/record/team_hitter_record.js"></script>
</head>
<body>
    <div class="contents">
        <%@include file="/WEB-INF/views/includes/team_record_title.jsp"%>
        <div class="team_hitter_record">
            <table class="table table-striped" id="regular_serise">
                <thead>
                  <tr>
                    <th scope="col">팀명</th>
                    <th scope="col">AVG</th>
                    <th scope="col">G</th>
                    <th scope="col">PA</th>
                    <th scope="col">AB</th>
                    <th scope="col">R</th>
                    <th scope="col">H</th>
                    <th scope="col">2B</th>
                    <th scope="col">3B</th>
                    <th scope="col">HR</th>
                    <th scope="col">TB</th>
                    <th scope="col">RBI</th>
                    <th scope="col">SAC</th>
                    <th scope="col">SF</th>
                    <th scope="col">BB</th>
                    <th scope="col">IBB</th>
                    <th scope="col">HBP</th>
                    <th scope="col">SO</th>
                    <th scope="col">GDP</th>
                    <th scope="col">SLG</th>
                    <th scope="col">OBP</th>
                    <th scope="col">OPS</th>
                    <th scope="col">MH</th>
                    <th scope="col">RISP</th>
                    <th scope="col">PH/BA</th>
                  </tr>
                </thead>
                <tbody id="team_hitter_record_tbody">
                    <c:if test="${hitter == null}">
                        <tr>
                            <td colspan="25">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${hitter}" var="item">
                        <tr>
                            <td>${item.thr_team_name}</td>
                            <td>${item.print_avg}</td>
                            <td>${item.thr_G}</td>
                            <td>${item.thr_PA}</td>
                            <td>${item.thr_AB}</td>
                            <td>${item.thr_R}</td>
                            <td>${item.thr_H}</td>
                            <td>${item.thr_2B}</td>
                            <td>${item.thr_3B}</td>
                            <td>${item.thr_HR}</td>
                            <td>${item.thr_TB}</td>
                            <td>${item.thr_RBI}</td>
                            <td>${item.thr_SAC}</td>
                            <td>${item.thr_SF}</td>
                            <td>${item.thr_BB}</td>
                            <td>${item.thr_IBB}</td>
                            <td>${item.thr_HBP}</td>
                            <td>${item.thr_SO}</td>
                            <td>${item.thr_GDP}</td>
                            <td>${item.print_slg}</td>
                            <td>${item.print_obp}</td>
                            <td>${item.print_ops}</td>
                            <td>${item.thr_MH}</td>
                            <td>${item.print_risp}</td>
                            <td>${item.print_ph_ba}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <table class="table table-striped" id="other_serise">
                <thead>
                  <tr>
                    <th scope="col">팀명</th>
                    <th scope="col">AVG</th>
                    <th scope="col">G</th>
                    <th scope="col">AB</th>
                    <th scope="col">R</th>
                    <th scope="col">H</th>
                    <th scope="col">2B</th>
                    <th scope="col">3B</th>
                    <th scope="col">HR</th>
                    <th scope="col">TB</th>
                    <th scope="col">RBI</th>
                    <th scope="col">SB</th>
                    <th scope="col">CS</th>
                    <th scope="col">BB</th>
                    <th scope="col">HBP</th>
                    <th scope="col">SO</th>
                    <th scope="col">GDP</th>
                    <th scope="col">E</th>
                  </tr>
                </thead>
                <tbody id="other_serise_tbody">
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>