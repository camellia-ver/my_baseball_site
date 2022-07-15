<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/player/player_hitter_record.css">
    <script src="/assets/js/record/player/player_hitter_record.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/player_record_title.jsp"%>
    <div class="contents">
        <div class="player_hitter_record">
            <table class="table table-striped" id="after_2002">
                <thead>
                  <tr>
                    <th scope="col">이름</th>
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
                    <th scope="col">PH-BA</th>
                  </tr>
                </thead>
                <tbody id="after_2002_tdody">
                    <c:forEach items="${hitter}" var="item">
                        <tr>
                            <td>${item.phrb_player_name}</td>
                            <td>${item.print_avg}</td>
                            <td>${item.phrb_G}</td>
                            <td>${item.phrb_PA}</td>
                            <td>${item.phrb_AB}</td>
                            <td>${item.phrb_R}</td>
                            <td>${item.phrb_H}</td>
                            <td>${item.phrb_2B}</td>
                            <td>${item.phrb_3B}</td>
                            <td>${item.phrb_HR}</td>
                            <td>${item.phrb_TB}</td>
                            <td>${item.phrb_RBI}</td>
                            <td>${item.phrb_SAC}</td>
                            <td>${item.phrb_SF}</td>
                            <td>${item.phrb_BB}</td>
                            <td>${item.phrb_IBB}</td>
                            <td>${item.phrb_HBP}</td>
                            <td>${item.phrb_SO}</td>
                            <td>${item.phrb_GDP}</td>
                            <td>${item.print_slg}</td>
                            <td>${item.print_obp}</td>
                            <td>${item.print_ops}</td>
                            <td>${item.phrb_MH}</td>
                            <td>${item.print_risp}</td>
                            <td>${item.print_ph_ba}</td>
                        </tr>
                    </c:forEach>`
                </tbody>
            </table>
            <table class="table table-striped" id="before_2002">
                <thead>
                  <tr>
                    <th scope="col">이름</th>
                    <th scope="col">AVG</th>
                    <th scope="col">G</th>
                    <th scope="col">PA</th>
                    <th scope="col">AB</th>
                    <th scope="col">H</th>
                    <th scope="col">2B</th>
                    <th scope="col">3B</th>
                    <th scope="col">HR</th>
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
                <tbody id="before_2002_tdody">
                </tbody>
            </table>
            <table class="table table-striped" id="detail">
                <thead>
                  <tr>
                    <th scope="col">이름</th>
                    <th scope="col">XBH</th>
                    <th scope="col">GO</th>
                    <th scope="col">AO</th>
                    <th scope="col">GO/AO</th>
                    <th scope="col">GW RBI</th>
                    <th scope="col">BB/K</th>
                    <th scope="col">P/PA</th>
                    <th scope="col">ISOP</th>
                    <th scope="col">XR</th>
                    <th scope="col">GPA</th>
                  </tr>
                </thead>
                <tbody id="detail_tdody">
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>