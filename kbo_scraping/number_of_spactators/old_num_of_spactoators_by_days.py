# 관중수 수집
# 일자별 관중수 수집
# 2020~2021 시즌

from unittest import result
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
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
driver.get("https://www.koreabaseball.com/History/Crowd/GraphDaily.aspx")

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

search_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_btnSearch"]')
select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlTeam"]')).select_by_value("SS")

#2020~2022 진행된 경기까지
for year in range(2020,2023):
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason"]')).select_by_value(str(year))
    search_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_btnSearch"]')
    search_btn.click()
    time.sleep(5)

    tbody = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
    tbody = tbody.split("\n")

    for data in tbody:
        result = data.split(" ")
        result[0] = result[0][:4] + result[0][5:7] + result[0][8:10]
        result[5] = result[5].replace(',','')
        save_data = "'" + "','".join(result) + "'"
        
        sql = "insert into num_of_spactoators(nos_date,day_of_the_weeks,home,away,baseball_stadium,spactoators)values(" + save_data + ')'

        cursor.execute(sql)
        db_connect.commit()

    time.sleep(5)

db_connect.close()