<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>my baseball data site</title>
        <link rel="stylesheet" href="/assets/css/include/num_of_spactoators_title.css">
    </head>
    <body>
        <div class="title">
            <p>관중현황</p>
        </div>
        <div class="select_table_graph">
            <a class="btn btn-primary" href="/num_of_spactoators" role="button"><i class="bi bi-calendar-date"></i> 일자별 관중현황</a>
            <a class="btn btn-primary" href="/num_of_spactoators/year" role="button"><i class="bi bi-graph-up"></i> 연도별 관중현황</a>
            <a class="btn btn-primary" href="/num_of_spactoators/graph" role="button"><i class="bi bi-clipboard2-data"></i> 관중현황 시각화</a>
        </div>
    </body>
</html>