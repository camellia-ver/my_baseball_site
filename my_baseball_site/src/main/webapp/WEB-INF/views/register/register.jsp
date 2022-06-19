<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/register/register.css">
    <script src="/assets/js/register/register.js"></script>
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>선수등록현황</p>
        </div>
        <div class="date_pick">
            <div class="btn_left">
                <button class="btn btn-primary" type="submit" id="left_btn"><</button>
            </div>
            <div class="today">
                <p id="print_today">${today_register[0].print_date}</p><br>
                <input type="date" id="input_date" class="form-control" aria-describedby="basic-addon1" max=${today_register[0].max_date} value=${today_register[0].max_date}>
            </div>
            <div class="btn_right">
                <button class="btn btn-primary" type="submit" id="right_btn">></button>
            </div>
        </div>
        </div>
        <div class="register">
            <h1>감독</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="register_manager_tbody">
                    <c:if test="${today_register == null}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.rg_position == '감독' && item.is_regist == ''}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <h1>코치</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="register_coach_tbody">
                    <c:if test="${today_register == null}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.rg_position == '코치' && item.is_regist == ''}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <h1>투수</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="register_p_tbody">
                    <c:if test="${today_register == null}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.rg_position == '투수' && item.is_regist == ''}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table> 
            <h1>포수</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="register_c_tbody">
                    <c:if test="${today_register == null}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.rg_position == '포수' && item.is_regist == ''}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table> 
            <h1>내야수</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="register_if_tbody">
                    <c:if test="${today_register == null}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.rg_position == '내야수' && item.is_regist == ''}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <h1>외야수</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="register_of_tbody">
                    <c:if test="${today_register == null}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.rg_position == '외야수' && item.is_regist == ''}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <h1>등록</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="regist_tbody">
                    <c:if test="${is_regist_or_out_register[0] == '0'}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.is_regist == '등록'}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <h1>말소</h1>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">등번호</th>
                    <th scope="col">이름</th>
                    <th scope="col">투타타입</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">체격</th>
                  </tr>
                </thead>
                <tbody id="register_out_tbody">
                    <c:if test="${is_regist_or_out_register[1] == '0'}">
                        <tr>
                            <td colspan="5">데이터가 없습니다.</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${today_register}" var="item">
                        <c:if test="${item.is_regist == '말소'}">
                            <tr>
                                <td>${item.rg_back_number}</td>
                                <td>${item.rg_name}</td>
                                <td>${item.rg_p_b_type}</td>
                                <td>${item.print_brith}</td>
                                <td>${item.rg_height}cm,${item.rg_weight}kg</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>