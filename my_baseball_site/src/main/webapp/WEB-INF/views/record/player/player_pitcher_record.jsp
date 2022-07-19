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
                <tbody id="after_2002_tdody">
                    <c:forEach items="${pitcher}" var="item">
                        <tr>
                            <td>${item.pprb_player_name}</td>
                            <td>${item.pprb_ERA}</td>
                            <td>${item.pprb_G}</td>
                            <td>${item.pprb_W}</td>
                            <td>${item.pprb_L}</td>
                            <td>${item.pprb_SV}</td>
                            <td>${item.pprb_HLD}</td>
                            <td>${item.print_wpct}</td>
                            <td>${item.pprb_IP}</td>
                            <td>${item.pprb_H}</td>
                            <td>${item.pprb_HR}</td>
                            <td>${item.pprb_BB}</td>
                            <td>${item.pprb_HBP}</td>
                            <td>${item.pprb_SO}</td>
                            <td>${item.pprb_R}</td>
                            <td>${item.pprb_ER}</td>
                            <td>${item.print_whip}</td>
                            <td>${item.pprb_CG}</td>
                            <td>${item.pprb_SHO}</td>
                            <td>${item.pprb_QS}</td>
                            <td>${item.pprb_BSV}</td>
                            <td>${item.pprb_TBF}</td>
                            <td>${item.pprb_NP}</td>
                            <td>${item.print_avg}</td>
                            <td>${item.pprb_2B}</td>
                            <td>${item.pprb_3B}</td>
                            <td>${item.pprb_SAC}</td>
                            <td>${item.pprb_SF}</td>
                            <td>${item.pprb_IBB}</td>
                            <td>${item.pprb_WP}</td>
                            <td>${item.pprb_BK}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <table class="table table-striped" id="before_2002">
                <thead>
                  <tr>
                    <th scope="col">이름</th>
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
                <tbody id="before_2002_tdody">
                </tbody>
            </table>
            <table class="table table-striped" id="detail">
                <thead>
                  <tr>
                    <th scope="col">이름</th>
                    <th scope="col">ERA</th>
                    <th scope="col">GS</th>
                    <th scope="col">Wgs</th>
                    <th scope="col">Wgr</th>
                    <th scope="col">GF</th>
                    <th scope="col">SVO</th>
                    <th scope="col">TS</th>
                    <th scope="col">GDP</th>
                    <th scope="col">GO</th>
                    <th scope="col">AO</th>
                    <th scope="col">GO/AO</th>
                    <th scope="col">BABIP</th>
                    <th scope="col">P/G</th>
                    <th scope="col">P/IP</th>
                    <th scope="col">K/9</th>
                    <th scope="col">BB/9</th>
                    <th scope="col">K/BB</th>
                    <th scope="col">OBP</th>
                    <th scope="col">SLG</th>
                    <th scope="col">OPS</th>
                  </tr>
                </thead>
                <tbody id="detail_tdody">
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>