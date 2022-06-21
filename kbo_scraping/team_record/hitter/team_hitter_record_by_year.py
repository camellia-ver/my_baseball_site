# 2022 ~ yesterday 팀 기록 수집
# 타자 기록, 정규리그 기록만 수집

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import cursors
import time,datetime

def getData(series,year):
    result_data = []

    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/table/tbody/tr')

    for content in contents:
        content = content.text.split(' ')
        del content[0]
        result_data.append(content)

    next_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/div/div/a[2]')
    next_btn.click()

    time.sleep(5)

    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/table/tbody/tr')

    for i,content in enumerate(contents):
        content = content.text.split(' ')
        del content[2]
        del content[1]
        del content[0]

        result_data[i].extend(content)
        result_data[i].append(year)
        result_data[i].append(series)

    for data in result_data:
        sql_data = "'" + "','".join(data) + "'"

        sql = "insert into team_hitter_record\
            (thr_team_name,thr_AVG,thr_G,thr_PA,thr_AB,\
            thr_R,thr_H,thr_2B,thr_3B,thr_HR,thr_TB,thr_RBI,\
            thr_SAC,thr_SF,thr_BB,thr_IBB,thr_HBP,thr_SO,thr_GDP,\
            thr_SLG,thr_OBP,thr_OPS,thr_MH,thr_RISP,thr_PH_BA,\
            thr_year,thr_series)values(" + sql_data + ')'
      
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

# 2001년~2022년
for year in range(2001,2023):
    year = str(year)
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason_ddlSeason"]')).select_by_value(year)

    time.sleep(5)
    getData("정규시즌",year)

    prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/div/div/a[1]')
    prev_btn.click()

db_connect.close()