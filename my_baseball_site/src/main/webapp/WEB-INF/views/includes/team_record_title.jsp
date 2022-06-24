<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>my baseball data site</title>
        <link rel="stylesheet" href="/assets/css/include/team_record_title.css">
    </head>
    <body>
        <div class="title">
            <p>팀 기록</p>
        </div>
        <div class="select_position">
            <a class="btn btn-primary" href="/team_hitter_record" role="button">타자</a>
            <a class="btn btn-primary" href="/team_pitcher_record" role="button">투수</a>
            <a class="btn btn-primary" href="/team_defense_record" role="button">수비</a>
            <a class="btn btn-primary" href="/team_runner_record" role="button">주루</a>
        </div>
        <div class="search_option">
            <select class="form-select" aria-label="Default select example" id="year_select">
                <c:forEach items="${regular_serise_year}" var="item">
                        <option value=${item}>${item}</option>
                </c:forEach>
            </select>
            <select class="form-select" aria-label="Default select example" id="series_select">
                <option value="정규시즌" selected>정규시즌</option>
                <option value="와일드카드">와일드카드</option>
                <option value="준플레이오프">준플레이오프</option>
                <option value="플레이오프">플레이오프</option>
                <option value="한국시리즈">한국시리즈</option>
            </select>
        </div>
    </body>
</html>