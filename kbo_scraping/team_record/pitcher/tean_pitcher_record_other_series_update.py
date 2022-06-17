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

        if len(content) == 21:
            content[12] = content[12] + ' ' + content[13]
            del content[13]

        del content[0]

        sql = "update team_pitcher_record set " + \
            "tpr_ERA = '"+content[1]+"', tpr_G = '"+content[2]+\
            "', tpr_CG = '"+content[3]+"', tpr_SHO = '"+content[4]+\
            "', tpr_W = '"+content[5]+"', tpr_L = '"+content[6]+\
            "', tpr_SV = '"+content[7]+"', tpr_HLD = '"+content[8]+\
            "', tpr_WPCT = '"+content[9]+"', tpr_TBF = '"+content[10]+\
            "', tpr_IP = '"+content[11]+"', tpr_H = '"+content[12]+\
            "', tpr_HR = '"+content[13]+"', tpr_BB = '"+content[14]+\
            "', tpr_HBP = '"+content[15]+"', tpr_SO = '"+content[16]+\
            "', tpr_R = '"+content[17]+"', tpr_ER = '"+content[18]+\
            "' where tpr_team_name = '"+content[0]+"' and tpr_year = '" + year + "' and tpr_series = '" + series + "'"
      
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

select_series = {'와일드카드':4,'준플레이오프':3,'플레이오프':5,'한국시리즈':7}

now = datetime.datetime.now()
cur_year = now.year

for series,i in select_series.items():
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeries_ddlSeries"]')).select_by_value(str(i))
    time.sleep(5)
    getData(series,str(cur_year))

    

db_connect.close()