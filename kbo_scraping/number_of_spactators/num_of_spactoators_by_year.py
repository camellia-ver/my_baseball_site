# 삼성 라이온즈 연도별 총 관중수와 평균 관중수

from unittest import result
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
driver.get("https://www.koreabaseball.com/History/Crowd/History.aspx")

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
    year = driver.find_element(by=By.XPATH,value=f'//*[@id="tblHistory"]/tbody/tr[{n}]/td[1]').text
    spactoators = driver.find_element(by=By.XPATH,value=f'//*[@id="tblHistory"]/tbody/tr[{n}]/td[2]').text
    spactoators = spactoators.replace("\n"," ")
    spactoators = spactoators.replace("(","")
    spactoators = spactoators.replace(")","")
    spactoators = spactoators.replace(",","")
    spactoators = spactoators.split(" ")

    save_data = "'" + year + "','" + "','".join(spactoators) + "'"

    sql = "insert into num_of_spactoators_by_year(nosby_year,sum_year,avg_one_game)values(" + save_data + ')'
            
    cursor.execute(sql)
    db_connect.commit()

    time.sleep(5)

db_connect.close()