# 올해 팀 기록 업데이트
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

    if len(contents) == 0:
        return

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

    for data in result_data:
        sql = "update team_hitter_record set thr_team_name ='" + data[0] + "',thr_AVG='"+data[1]+"',thr_G='"+data[2]+"',thr_PA='"+data[3]+"',thr_AB='"+data[4]+"',thr_R='"+data[5]+"',thr_H='"+data[6]+"',thr_2B='"+data[7]+"',thr_3B='"+data[8]+"',thr_HR='"+data[9]+"',thr_TB='"+data[10]+"',thr_RBI='"+data[11]+"',thr_SAC='"+data[12]+"',thr_SF='"+data[13]+"',thr_BB='"+data[14]+"',thr_IBB='"+data[15]+"',thr_HBP='"+data[16]+"',thr_SO='"+data[17]+"',thr_GDP='"+data[18]+"',thr_SLG='"+data[19]+"',thr_OBP='"+data[20]+"',thr_OPS='"+data[21]+"',thr_MH='"+data[22]+"',thr_RISP='"+data[23]+"',thr_PH_BA='"+data[24] + 'where thr_year = ' + year
        
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

now = datetime.datetime.now()
cur_year = now.year

time.sleep(5)
data = getData("정규시즌",cur_year)

# select_series = {'와일드카드':4,'준플레이오프':3,'플레이오프':5,'한국시리즈':7}
    
# for series,i in select_series.items():
#     select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeries_ddlSeries"]')).select_by_value(str(i))
#     time.sleep(5)
#     getData(series,cur_year)

db_connect.close()