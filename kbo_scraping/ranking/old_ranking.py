# KBO 순위 정보 수집
# 시범 경기 외의 정규리그 순위만 수집
# 1982 ~ 2021의 최종순위

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.keys import Keys
import requests
from bs4 import BeautifulSoup
import time
import pymysql
from pymysql import cursors

url = "https://www.koreabaseball.com/TeamRank/TeamRank.aspx"

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get(url)

response = requests.get(url)
html = response.text
soup = BeautifulSoup(html,'html.parser')

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

# 1999,2000 양대리그
for year in range(1982,2022):
    # select = Select(driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_ddlYear"]')).select_by_value(str(year))
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlYear"]')).select_by_value(str(year))
    time.sleep(1)
    if year == 1999 or year == 2000:
        # 드림리그
        # tbody1 = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
        tbody1 = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
        # 매직리그
        # tbody2 = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_pnlMagicLeague"]/table/tbody').text
        tbody2 = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_pnlMagicLeague"]/table/tbody').text
        
        tbody1 = tbody1.split('\n')
        tbody2 = tbody2.split('\n')

        for rank in tbody1:
            save_data = rank.split(' ')
            save_date = str(year) + "1231"
            save_data[1] = "'" + save_data[1] + "'"
            save_data[8] = "'" + save_data[8] + "'"
            save_data[9] = "'" + save_data[9] + "'"
            save_data[10] = "'" + save_data[10] + "'"
            save_data[11] = "'" + save_data[11] + "'"
            save_data = ','.join(save_data) + ',' + save_date + ",'드림리그'"
            sql = "insert into ranking(no,team_name,game,win,lose,tie,win_rate,game_difference,last_10_matches,continuity,home,away,r_date,uniqueness)values(" + save_data + ')'
        
            cursor.execute(sql)
            db_connect.commit()

        for rank in tbody2:
            save_data = rank.split(' ')
            save_date = str(year) + "1231"
            save_data[1] = "'" + save_data[1] + "'"
            save_data[8] = "'" + save_data[8] + "'"
            save_data[9] = "'" + save_data[9] + "'"
            save_data[10] = "'" + save_data[10] + "'"
            save_data[11] = "'" + save_data[11] + "'"
            save_data = ','.join(save_data) + ',' + save_date + ",'매직리그'"
    
            sql = "insert into ranking(no,team_name,game,win,lose,tie,win_rate,game_difference,last_10_matches,continuity,home,away,r_date,uniqueness)values(" + save_data + ')'
            
            cursor.execute(sql)
            db_connect.commit()
    else:
        # tbody = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
        tbody = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
        tbody = tbody.split('\n')
        for rank in tbody:
            save_data = rank.split(' ')
            save_date = str(year) + "1231"
            save_data[1] = "'" + save_data[1] + "'"
            save_data[8] = "'" + save_data[8] + "'"
            save_data[9] = "'" + save_data[9] + "'"
            save_data[10] = "'" + save_data[10] + "'"
            save_data[11] = "'" + save_data[11] + "'"
            save_data = ','.join(save_data) + ',' + save_date + ",'단일리그'"
    
            sql = "insert into ranking(no,team_name,game,win,lose,tie,win_rate,game_difference,last_10_matches,continuity,home,away,r_date,uniqueness)values(" + save_data + ')'
    
            cursor.execute(sql)
            db_connect.commit()
    time.sleep(5)

# select = Select(driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_ddlYear"]')).select_by_value("2022")
select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlYear"]')).select_by_value("2022")
# prev_btn = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_btnPreDate"]')
# prev_btn.click()

# date = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_lblSearchDateTitle"]').text
date = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_lblSearchDateTitle"]').text

while date != "2022.04.02(토)":
    # driver.implicitly_wait(10)
    # prev_btn = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_btnPreDate"]')
    prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_btnPreDate"]')
    prev_btn.click()

    time.sleep(10)
    # date = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_lblSearchDateTitle"]').text
    date = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_lblSearchDateTitle"]').text
    save_date = date[:4] + date[5:7] + date[8:10]
    
    # tbody = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
    tbody = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
    tbody = tbody.split('\n')
    
    time.sleep(10)
    for rank in tbody:
        save_data = rank.split(' ')
        save_data[1] = "'" + save_data[1] + "'"
        save_data[8] = "'" + save_data[8] + "'"
        save_data[9] = "'" + save_data[9] + "'"
        save_data[10] = "'" + save_data[10] + "'"
        save_data[11] = "'" + save_data[11] + "'"
        save_data = ','.join(save_data) + ',' + save_date + ",'단일리그'"

        sql = "insert into ranking(no,team_name,game,win,lose,tie,win_rate,game_difference,last_10_matches,continuity,home,away,r_date,uniqueness)values(" + save_data + ')'
    
        cursor.execute(sql)
        db_connect.commit()

db_connect.close()