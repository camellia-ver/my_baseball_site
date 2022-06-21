# 1982 ~ 2001까지의 기본기록
# 정규리그 기록만

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import cursors
import time

def getDataBefore2001(series,year):
    result_data = []

    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/table/tbody/tr')

    for content in contents:
        content = content.text.split(' ')
        del content[0]
        del content[1]
            
        if content[1] == '-':
            content[1] = '-1'

        content.append(year)
        content.append(series)
        result_data.append(content)

    for data in result_data:
        sql_data = "'" + "','".join(data) + "'"

        sql = "insert into player_hitter_record_basic\
            (phrb_player_name,phrb_AVG,phrb_G,\
            phrb_PA,phrb_AB,phrb_H,phrb_2B,phrb_3B,phrb_HR,\
            phrb_RBI,phrb_SB,phrb_CS,phrb_BB,\
            phrb_HBP,phrb_SO,phrb_GDP,phrb_E,phrb_year,phrb_series)\
            values(" + sql_data + ')'
        
        cursor.execute(sql)
        db_connect.commit()

def getDataAfter2001(series,year):
    result_data = []

    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[3]/table/tbody/tr')

    for content in contents:
        content = content.text.split(' ')
        del content[0]
        del content[1]

        result_data.append(content)

    next_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/div[2]/a[2]')
    next_btn.click()

    time.sleep(5)

    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[3]/table/tbody/tr')

    for i,content in enumerate(contents):
        content = content.text.split(' ')
        del content[3]
        del content[2]
        del content[1]
        del content[0]

        result_data[i].extend(content)
        result_data[i].append(year)
        result_data[i].append(series)

    for data in result_data:
        sql_data = "'" + "','".join(data) + "'"

        sql_data = sql_data.replace('-','-1')

        sql = "insert into player_hitter_record_basic\
            (phrb_player_name,phrb_AVG,phrb_G,phrb_PA,\
            phrb_AB,phrb_R,phrb_H,phrb_2B,phrb_3B,phrb_HR,phrb_TB,\
            phrb_RBI,phrb_SAC,phrb_SF,phrb_BB,\
            phrb_IBB,phrb_HBP,phrb_SO,phrb_GDP,phrb_SLG,\
            phrb_OBP,phrb_OPS,phrb_MH,phrb_RISP,phrb_PH_BA,\
            phrb_year,phrb_series)values(" + sql_data + ')'
        
        cursor.execute(sql)
        db_connect.commit()

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Record/Player/HitterBasic/BasicOld.aspx?sort=HRA_RT")

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

select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlTeam_ddlTeam"]')).select_by_value("SS")
time.sleep(5)

select_position = {'포수':'2','내야수':'3,4,5,6','외야수':'7,8,9'}

for year in range(1982,2002):
    year = str(year)
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason_ddlSeason"]')).select_by_value(year)

    time.sleep(5)

    for i in select_position.values():
        select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlPos_ddlPos"]')).select_by_value(i)
        time.sleep(10)
        getDataBefore2001("정규시즌",year)

for year in range(2002,2023):
    year = str(year)
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason_ddlSeason"]')).select_by_value(year)
    
    time.sleep(5)
    
    for i in select_position.values():
        select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlPos_ddlPos"]')).select_by_value(i)
        time.sleep(10)
        getDataAfter2001("정규시즌",year)

        prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/div[2]/a[1]')
        prev_btn.click()

db_connect.close()