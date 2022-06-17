# 2022 ~ yesterday 팀 기록 수집
# 타자 기록

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

def getData(series,year):
    result_data = []

    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/table/tbody/tr')

    for content in contents:
        content = content.text.split(' ')
        if len(content) == 19:
            content[9] = content[9] + ' ' + content[10]
            del content[10]
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

        sql = "insert into team_pitcher_record\
            (tpr_team_name,tpr_ERA,tpr_G,tpr_W,tpr_L,tpr_SV,tpr_HLD,\
            tpr_WPCT,tpr_IP,tpr_H,tpr_HR,tpr_BB,tpr_HBP,tpr_SO,tpr_R,\
            tpr_ER,tpr_WHIP,tpr_CG,tpr_SHO,tpr_QS,tpr_BSV,tpr_TBF,tpr_NP,\
            tpr_AVG,tpr_2B,tpr_3B,tpr_SAC,tpr_SF,tpr_IBB,tpr_WP,tpr_BK,\
            tpr_year,tpr_series)values(" + sql_data + ')'
        
        cursor.execute(sql)
        db_connect.commit()

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Record/Team/Pitcher/Basic1.aspx")

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
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason_ddlSeason"]')).select_by_value(str(year))

    time.sleep(5)
    data = getData("정규시즌",year)

    prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/div/div/a[1]')
    prev_btn.click()

    # select_series = {'와일드카드':4,'준플레이오프':3,'플레이오프':5,'한국시리즈':7}
    
    # for series,i in select_series.items():
    #     select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeries_ddlSeries"]')).select_by_value(str(i))
    #     time.sleep(5)
    #     getData(series,year)

db_connect.close()