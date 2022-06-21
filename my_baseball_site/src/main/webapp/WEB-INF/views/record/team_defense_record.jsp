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
                <c:forEach items="${regular_serise_year}" var="item">
                        <option value=${item}>${item}</option>
                </c:forEach>
            </select>
        </div>
        <div class="team_defense_record">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">팀명</th>
                    <th scope="col">G</th>
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
                <tbody id="team_defense_record_tbody">
                    <c:if test="${defense == null}">
                        <tr colspan="12">
                            <td>데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${defense}" var="item">
                        <tr>
                            <td>${item.tdr_team_name}</td>
                            <td>${item.tdr_G}</td>
                            <td>${item.tdr_E}</td>
                            <td>${item.tdr_PKO}</td>
                            <td>${item.tdr_PO}</td>
                            <td>${item.tdr_A}</td>
                            <td>${item.tdr_DP}</td>
                            <td>${item.print_fpct}</td>
                            <td>${item.tdr_PB}</td>
                            <td>${item.tdr_SB}</td>
                            <td>${item.tdr_CS}</td>
                            <td>${item.tdr_CS_PERSENT}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>