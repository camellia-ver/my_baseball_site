# KBO 순위 정보 수집
# 시범 경기 외의 정규리그 순위만 수집
# 현시점의 순위를 수집

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import cursors
import time

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/TeamRank/TeamRank.aspx")

db_connect = pymysql.connect(
    user='root',
    passwd='1234',
    host='127.0.0.1',
    db='kbo_data',
    charset='utf8'
)

if not db_connect:
    print("연결 실패")    
    db_connect.close()
    exit(0)
else:
    print("연결 성공")

cursor = db_connect.cursor(cursors.DictCursor)

# 몇일 전 기록까지 저장 할지, 1 : 오늘 것만,2 : 어제 것 까지
prev_day = 1

for i in range(prev_day):
    time.sleep(10)

    date = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_lblSearchDateTitle"]').text
    save_date = date[:4] + date[5:7] + date[8:10]

    tbody = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
    tbody = tbody.split('\n')

    for rank in tbody:
        save_data = rank.split(' ')
        save_data[1] = "'" + save_data[1] + "'"
        save_data[8] = "'" + save_data[8] + "'"
        save_data[9] = "'" + save_data[9] + "'"
        save_data[10] = "'" + save_data[10] + "'"
        save_data[11] = "'" + save_data[11] + "'"
        save_data = ','.join(save_data) + ',' + save_date + ",'단일리그','리그진행중'"
        
        sql = "insert into ranking(no,team_name,game,win,lose,tie,win_rate,game_difference,last_10_matches,continuity,home,away,r_date,uniqueness,note)values(" + save_data + ')'

        cursor.execute(sql)
        db_connect.commit()

    prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_btnPreDate"]')
    prev_btn.click()

db_connect.close()