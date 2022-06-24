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
            <p>개인 기록</p>
        </div>
        <div class="select_position">
            <a class="btn btn-primary" href="/player_hitter_record" role="button">타자</a>
            <a class="btn btn-primary" href="/player_pitcher_record" role="button">투수</a>
            <a class="btn btn-primary" href="/player_defense_record" role="button">수비</a>
            <a class="btn btn-primary" href="/player_runner_record" role="button">주루</a>
        </div>
        <div class="search_option">
            <select class="form-select" aria-label="Default select example" id="year_select">
            </select>
            <select class="form-select" aria-label="Default select example" id="series_select">
                <option value="정규시즌" selected>정규시즌</option>
                <option value="와일드카드">와일드카드</option>
                <option value="준플레이오프">준플레이오프</option>
                <option value="플레이오프">플레이오프</option>
                <option value="한국시리즈">한국시리즈</option>
            </select>
            <select class="form-select" aria-label="Default select example" id="position_select">
                <option value="전체" selected>전체</option>
                <option value="포수">포수</option>
                <option value="내야수">내야수</option>
                <option value="외야수">외야수</option>
            </select>
        </div>
        <div class="select_data">
            <button type="button" class="btn btn-link" id="basic_record">기본기록</button>
            <button type="button" class="btn btn-link" id="detail_record">세부기록</button>
        </div>
    </body>
</html>