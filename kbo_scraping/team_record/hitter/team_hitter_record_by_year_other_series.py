# 2022 ~ yesterday 팀 기록 수집
# 타자 기록, 정규리그 기록만 수집

from asyncio import constants
from unittest import result
from certifi import contents
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import NULL, cursors
import time,datetime

def getData(series,year):
    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/table/tbody/tr')

    if len(contents) == 0:
        return

    for content in contents:
        content = content.text.split(' ')

        del content[0]
        content.append(year)
        content.append(series)

        sql_data = "'" + "','".join(content) + "'"

        sql = "insert into team_hitter_record(\
            thr_team_name,thr_AVG,thr_G,thr_AB,thr_R,\
            thr_H,thr_2B,thr_3B,thr_HR,thr_TB,thr_RBI,\
            thr_SB,thr_CS,thr_BB,thr_HBP,thr_SO,thr_GDP,thr_E,\
            thr_year,thr_series\
            )values(" + sql_data + ')'
      
        cursor.execute(sql)
        db_connect.commit()

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Record/Team/Hitter/Basic1.aspx")

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

select_series = {'와일드카드':4,'준플레이오프':3,'플레이오프':5,'한국시리즈':7}

# 1982년~2021년
for year in range(1982,2022):
    year = str(year)

    for series,i in select_series.items():
        select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeries_ddlSeries"]')).select_by_value(str(i))
        time.sleep(10)
        select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason_ddlSeason"]')).select_by_value(year)
        time.sleep(10)
        getData(series,year)

db_connect.close()