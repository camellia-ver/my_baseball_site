# 역대 골든글로브 수상자 기록 수집

from unittest import result
from numpy import save
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
driver.get("https://www.koreabaseball.com/History/Etc/GoldenGlove.aspx")

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

# 1982 ~ 2021
for i in range(1982,2022):
    i -= cur_year
    if i < 0: i = -i

    n = str(i)
    content = driver.find_element(by=By.XPATH,value=f'//*[@id="contents"]/div[2]/table/tbody/tr[{n}]').text
    content = content.replace('\n','/')
    content = content.replace('/',' ')
    content = content.replace('-',' ')
    content = content.split(' ')

    if len(content) == 19:
        content.append('')
        content.append('')
    if len(content) != 23:
        content.insert(19,'')
        content.insert(20,'')

    content[0] = content[0][:-1]

    save_data = "'" + "','".join(content) + "'"

    sql = "insert into golden_glove(gg_year,gg_P_name,gg_P_team,gg_C_name,gg_C_team,gg_1B_name,gg_1B_team,gg_2B_name,gg_2B_team,gg_3B_name,gg_3B_team,gg_SS_name,gg_SS_team,gg_OF_name1,gg_OF_team1,gg_OF_name2,gg_OF_team2,gg_OF_name3,gg_OF_team3,gg_OF_name4,gg_OF_team4,gg_DH_name,gg_DH_team)values(" + save_data + ')'
            
    cursor.execute(sql)
    db_connect.commit()

    time.sleep(5)

db_connect.close()