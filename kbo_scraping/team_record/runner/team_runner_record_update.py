# 올해 팀 기록 업데이트
# 주루 기록, 정규리그 기록만 존재

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

        sql_data = "'" + ",'".join(content) + "'"

        sql = "update team_runner_record set "\
            +"trr_G = '"+content[1]+"', trr_SBA = '"+content[2]\
            +"', trr_SB = '"+content[3]+"', trr_CS = '"+content[4]\
            +"', trr_SB_PERSENT = '"+content[5]+"', trr_OOB = '"+content[6]\
            +"', trr_PKO = '" + content[7]\
            +"' where trr_team_name = '" + content[0] + "' and tdr_year = '" + year + "'"

        cursor.execute(sql)
        db_connect.commit()

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Record/Team/Runner/Basic.aspx")

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

now = datetime.datetime.now()
cur_year = now.year

time.sleep(5)
data = getData(str(cur_year))

db_connect.close()