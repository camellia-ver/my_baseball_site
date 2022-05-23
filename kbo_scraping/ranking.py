# KBO 순위 정보 수집
# 시범 경기 외의 정규리그 순위만 수집
# 1982~2021 동안의 순위는 최종 순위만 수집
# 2022 ~ ing는 4월2일 개막전 부터 시즌 종료일까지의 매일 순위 정보 수집

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By

# 크롬 드라이버 자동 업데이트
from webdriver_manager.chrome import ChromeDriverManager

import time
import pyautogui
import pyperclip

# 브라우저 꺼짐 방지
chrome_options = Options()
chrome_options.add_experimental_option("detach",True)

# 불필요한 에러 메시지 없에기
chrome_options.add_experimental_option("excludeSwitches",["enable-logging"])

# 창 숨기기
chrome_options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=chrome_options)

# 웹페이지 해당 주소 이동
driver.implicitly_wait(5) # 웹페이지가 로딩 될때까지 5초는 기다림
driver.maximize_window() # 화면 최대화
driver.get("https://www.koreabaseball.com/TeamRank/TeamRank.aspx")

