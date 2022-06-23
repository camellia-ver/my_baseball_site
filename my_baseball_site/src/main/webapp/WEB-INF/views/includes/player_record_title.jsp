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
            <a class="btn btn-primary" href="/player_hitter_record" role="button">타자</a>
            <a class="btn btn-primary" href="/player_pitcher_record" role="button">투수</a>
            <a class="btn btn-primary" href="/player_defense_record" role="button">수비</a>
            <a class="btn btn-primary" href="/player_runner_record" role="button">주루</a>
        </div>
    </body>
</html>