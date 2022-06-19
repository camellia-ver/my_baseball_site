<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>baseball data site</title>
    <link rel="stylesheet" href="/assets/css/record/baseball_word.css">
</head>
<body>
    <div class="contents">
        <div class="title">
            <p>야구 기록 용어</p>
        </div>
        <div class="word_area">
            <div>
                <h1>타자</h1>
                <div>
                    <p>
                        <span>2B : 2루타</span>
                        <span>3B : 3루타</span>
                        <span>AB : 타수</span>
                        <span>AO : 뜬공</span>
                        <span>AVG : 타율</span>
                        <span>BB : 볼넷</span>
                        <span>BB/K : 볼넷/삼진</span>
                    </p>
                    <p>
                        <span>CS : 도루실패</span>
                        <span>E : 실책</span>
                        <span>G : 경기</span>
                        <span>GDP : 병살타</span>
                        <span>GO : 땅볼</span>
                        <span>GO/AO : 땅볼/뜬공</span>
                    </p>
                    <p>
                        <span>GPA : (1.8x출루율+장타율)/4</span>
                        <span>GW RBI : 결승타</span>
                        <span>H : 안타</span>
                        <span>HBP : 사구</span>
                        <span>HR : 홈런</span>
                        <span>IBB : 고의4구</span>
                    </p>
                    <p>
                        <span>ISOP : 순수장타율</span>
                        <span>MH : 멀티히트</span>
                        <span>OBP : 출루율</span>
                        <span>OPS : 출루율+장타율</span>
                        <span>P/PA : 투구수/타석</span>
                        <span>PA : 타석</span>
                    </p>
                    <p>
                        <span>PH-BA : 대타타율</span>
                        <span>R : 득점</span>
                        <span>RBI : 타점</span>
                        <span>RISP : 득점권타율</span>
                        <span>SAC : 희생번트</span>
                        <span>SB : 도루</span>
                        <span>SF : 희생플라이</span>
                    </p>
                    <p>
                        <span>SLG : 장타율</span>
                        <span>SO : 삼진</span>
                        <span>TB: 루타</span>
                        <span>XBH : 장타</span>
                        <span>XR : 추정득점</span>
                    </p>
                </div>
            </div>
            <div>
                <h1>투수</h1>
                <div>
                    <p>
                        <span>2B : 2루타</span>
                        <span>3B : 3루타</span>
                        <span>AO : 뜬공</span>
                        <span>AVG : 피안타율</span>
                        <span>BABIP : 인플레이타구타율</span>
                        <span>BB : 볼넷</span>
                    </p>
                    <p>
                        <span>BB/9 : 9이닝당 볼넷</span>
                        <span>BK : 보크</span>
                        <span>BSV : 블론세이브</span>
                        <span>CG : 완투</span>
                        <span>ER : 자책점</span>
                        <span>ERA : 평균자책점</span>
                        <span>G : 경기</span>
                    </p>
                    <p>
                        <span>GDP : 병살타</span>
                        <span>GF : 종료</span>
                        <span>GO : 땅볼</span>
                        <span>GO/AO : 땅볼/뜬공</span>
                        <span>GS : 선발</span>
                        <span>H : 피안타</span>
                        <span>HBP : 사구</span>
                    </p> 
                    <p>
                        <span>HLD : 홀드</span>
                        <span>HR : 홈런</span>
                        <span>IBB : 고의4구</span>
                        <span>IP : 이닝</span>
                        <span>K/9 : 9이닝당 삼진</span>
                        <span>K/BB : 삼진/볼넷</span>
                        <span>L : 패</span>
                    </p>
                    <p>
                        <span>NP : 투구수</span>
                        <span>OBP : 피출루율</span>
                        <span>OPS : 피출루율+피장타율</span>
                        <span>P/G : 투구수/경기</span>
                        <span>P/IP : 투구수/이닝</span>
                    </p> 
                    <p>
                        <span>QS : 퀄리티스타트</span>
                        <span>R : 실점</span>
                        <span>SAC : 희생번트</span>
                        <span>SF : 희생플라이</span>
                        <span>SHO : 완봉</span>
                        <span>SLG : 피장타율</span>
                        <span>SO : 삼진</span>
                    </p> 
                    <p>
                        <span>SV : 세이브</span>
                        <span>SVO : 세이브기회</span>
                        <span>TBF : 타자수</span>
                        <span>TS : 터프세이브</span>
                        <span>W : 승</span>
                        <span>Wgr : 구원승</span>
                        <span>Wgs : 선발승</span>
                    </p>
                    <p>
                        <span>WHIP : 이닝당 출루허용률</span>
                        <span>WP : 폭투</span>
                        <span>WPCT : 승률</span>
                    </p>
                </div>
            </div>
            <div>
                <h1>수비</h1>
                <div>
                    <p>
                        <span>A : 보살</span>
                        <span>CS : 도루저지</span>
                        <span>CS% : 도루저지율</span>
                        <span>DP : 병살</span>
                        <span>E : 실책</span>
                        <span>FPCT : 수비율</span>
                        <span>G : 경기</span>
                    </p>
                    <p>
                        <span>GS : 선발경기</span>
                        <span>PB : 포일</span>
                        <span>PKO : 견제사</span>
                        <span>PO : 자살</span>
                        <span>POS : 포지션</span>
                        <span>SB : 도루허용</span>
                    </p>
                </div>
            </div>
            <div>
                <h1>주루</h1>
                <div>
                    <p>
                        <span>CS : 도루실패</span>
                        <span>G : 경기</span>
                        <span>OOB : 주루사</span>
                        <span>PKO : 견제사</span>
                        <span>SB : 도루</span>
                        <span>SB% : 도루성공률</span>
                        <span>SBA : 도루시도</span>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>