<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/team_pitcher_record.css">
    <script src="/assets/js/record/team_pitcher_record.js"></script>
</head>
<body>
    <div class="contents">
        <%@include file="/WEB-INF/views/includes/team_record_title.jsp"%>
        <div class="team_pitcher_record">
            <table class="table table-striped" id="regular_serise">
                <thead>
                  <tr>
                    <th scope="col">팀명</th>
                    <th scope="col">ERA</th>
                    <th scope="col">G</th>
                    <th scope="col">W</th>
                    <th scope="col">L</th>
                    <th scope="col">SV</th>
                    <th scope="col">HLD</th>
                    <th scope="col">WPCT</th>
                    <th scope="col">IP</th>
                    <th scope="col">H</th>
                    <th scope="col">HR</th>
                    <th scope="col">BB</th>
                    <th scope="col">HBP</th>
                    <th scope="col">SO</th>
                    <th scope="col">R</th>
                    <th scope="col">ER</th>
                    <th scope="col">WHIP</th>
                    <th scope="col">CG</th>
                    <th scope="col">SHO</th>
                    <th scope="col">QS</th>
                    <th scope="col">BSV</th>
                    <th scope="col">TBF</th>
                    <th scope="col">NP</th>
                    <th scope="col">AVG</th>
                    <th scope="col">2B</th>
                    <th scope="col">3B</th>
                    <th scope="col">SAC</th>
                    <th scope="col">SF</th>
                    <th scope="col">IBB</th>
                    <th scope="col">WP</th>
                    <th scope="col">BK</th>
                  </tr>
                </thead>
                <tbody id="team_pitcher_record_tbody">
                    <c:if test="${pitcher == null}">
                        <tr>
                            <td colspan="31">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${pitcher}" var="item">
                        <tr>
                            <td>${item.tpr_team_name}</td>
                            <td>${item.print_era}</td>
                            <td>${item.tpr_G}</td>
                            <td>${item.tpr_W}</td>
                            <td>${item.tpr_L}</td>
                            <td>${item.tpr_SV}</td>
                            <td>${item.tpr_HLD}</td>
                            <td>${item.print_wptc}</td>
                            <td>${item.tpr_IP}</td>
                            <td>${item.tpr_H}</td>
                            <td>${item.tpr_HR}</td>
                            <td>${item.tpr_BB}</td>
                            <td>${item.tpr_HBP}</td>
                            <td>${item.tpr_SO}</td>
                            <td>${item.tpr_R}</td>
                            <td>${item.tpr_ER}</td>
                            <td>${item.print_whip}</td>
                            <td>${item.tpr_CG}</td>
                            <td>${item.tpr_SHO}</td>
                            <td>${item.tpr_QS}</td>
                            <td>${item.tpr_BSV}</td>
                            <td>${item.tpr_TBF}</td>
                            <td>${item.tpr_NP}</td>
                            <td>${item.print_avg}</td>
                            <td>${item.tpr_2B}</td>
                            <td>${item.tpr_3B}</td>
                            <td>${item.tpr_SAC}</td>
                            <td>${item.tpr_SF}</td>
                            <td>${item.tpr_IBB}</td>
                            <td>${item.tpr_WP}</td>
                            <td>${item.tpr_BK}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <table class="table table-striped" id="other_serise">
                <thead>
                    <tr>
                        <th scope="col">팀명</th>
                        <th scope="col">ERA</th>
                        <th scope="col">G</th>
                        <th scope="col">CG</th>
                        <th scope="col">SHO</th>
                        <th scope="col">W</th>
                        <th scope="col">L</th>
                        <th scope="col">SV</th>
                        <th scope="col">HLD</th>
                        <th scope="col">WPCT</th>
                        <th scope="col">TBF</th>
                        <th scope="col">IP</th>
                        <th scope="col">H</th>
                        <th scope="col">HR</th>
                        <th scope="col">BB</th>
                        <th scope="col">HBP</th>
                        <th scope="col">SO</th>
                        <th scope="col">R</th>
                        <th scope="col">ER</th>
                      </tr>
                </thead>
                <tbody id="other_serise_tbody">
                </tbody>
            </table>
    </div>
</body>
</html>