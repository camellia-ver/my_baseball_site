<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/index.css">
</head>
<body>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
    <div class="contents">
        <div class="content_left">
            <div class="today_game_result">
                5월 27일 삼성 0 VS 5 LG
                <p>패배</p> 
            </div>
            <div class="today_ranking">
                <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Handle</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                      </tr>
                      <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                      </tr>
                      <tr>
                        <th scope="row">3</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                      <tr>
                        <th scope="row">4</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                      <tr>
                        <th scope="row">5</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                      <tr>
                        <th scope="row">6</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                      <tr>
                        <th scope="row">7</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                      <tr>
                        <th scope="row">8</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                      <tr>
                        <th scope="row">9</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                      <tr>
                        <th scope="row">10</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                      </tr>
                    </tbody>
                  </table>
            </div>
        </div>
        <div class="content_right">
            <div class="game_schedule">
                <div class="schedule">
                    <p>5월 28일 경기</p>
                    <p>삼성 VS LG 잠실</p>
                </div>
                <div class="schedule">
                    <p>5월 28일 경기</p>
                    <p>삼성 VS LG 잠실</p>
                </div>
                <div class="schedule">
                    <p>5월 28일 경기</p>
                    <p>삼성 VS LG 잠실</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
