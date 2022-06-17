# 2022 ~ yesterday 팀 기록 수집
# 수비 기록, 정규리그 기록만 존재

from unittest import result
from certifi import contents
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import cursors
import time,datetime

def getData(year):
    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/table/tbody/tr')

    for content in contents:
        content = content.text.split(' ')
        del content[0]
        content.append(year)

        sql_data = "'" + "','".join(content) + "'"

        sql = "insert into team_defense_record(tdr_team_name,tdr_G,tdr_E,tdr_PKO,tdr_PO,tdr_A,tdr_DP,tdr_FPCT,tdr_PB,tdr_SB,tdr_CS,tdr_CS_PERSENT,tdr_year)values(" + sql_data + ')'
        
        cursor.execute(sql)
        db_connect.commit()

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Record/Team/Defense/Basic.aspx")

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

# 2001년~2022년
for year in range(2001,2023):
    year = str(year)
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason_ddlSeason"]')).select_by_value(year)

    time.sleep(5)
    data = getData(year)

db_connect.close()