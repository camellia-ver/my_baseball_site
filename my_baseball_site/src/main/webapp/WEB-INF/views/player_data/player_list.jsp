<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/player_data/player_list.css">
    <script src="/assets/js/player_data/player_list.js"></script>
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>선수명단</p>
        </div>
        <div class="select_data">
            <select class="form-select" aria-label="Default select example" id="select_position">
                <option value="전체" selected>포지션 선택</option>
                <option value="투수">투수</option>
                <option value="포수">포수</option>
                <option value="내야수">내야수</option>
                <option value="외야수">외야수</option>
            </select>
            <div class="input-group mb-3" id="name_input">
                <span class="input-group-text" id="inputGroup-sizing-default">이름  </span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" id="input_form">
            </div>
            <button class="btn btn-primary" type="submit" id="search_btn">검색</button>
        </div>
        <div class="player_list">
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">선수명</th>
                    <th scope="col">포지션</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                    <th scope="col">출신교</th>
                  </tr>
                </thead>
                <tbody id="player_list_tbody">
                    <c:forEach items="${list}" var="item">
                        <tr>
                            <td>${item.backnumber}</td>
                            <td><a href="/detail?name=${item.name}&birth=${item.birth}">${item.name}</a></td>
                            <td>${item.position1}</td>
                            <td>${item.birth}</td>
                            <td>${item.height}cm, ${item.weight}kg</td>
                            <td>${item.career}</td>
                        </tr>
                    </c:forEach>
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>
