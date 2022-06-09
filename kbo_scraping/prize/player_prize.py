# 역대 개인수상 기록 수집

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

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/History/Etc/PlayerPrize.aspx")

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

for i in range(1982,2022):
    i -= cur_year
    if i < 0: i = -i

    n = str(i)

    content = driver.find_element(by=By.XPATH,value=f'//*[@id="contents"]/div[2]/table/tbody/tr[{n}]').text
    content = content.replace('(',' ')
    content = content.replace(')','')
    content = content.replace(',',' ')
    content = content.split(' ')

    for idx,c in enumerate(content):
        if c == '해당자':
            content[idx] = content[idx] + ' ' + content[idx+1]
            del content[idx+1]
            content.insert(idx+1,'')
            content.insert(idx+2,'')

    save_data = "'" + "','".join(content) + "'"

    sql = "insert into player_prize(pp_year,kbo_mvp_name,kbo_mvp_team,kbo_mvp_position,kbo_new_man_name,kbo_new_man_team,kbo_new_man_position,kbo_all_star_mvp_name,kbo_all_star_mvp_team,kbo_all_star_mvp_position,kbo_korea_series_mvp_name,kbo_korea_series_mvp_team,kbo_korea_series_mvp_position)values(" + save_data + ')'
            
    cursor.execute(sql)
    db_connect.commit()

    time.sleep(5)

db_connect.close()