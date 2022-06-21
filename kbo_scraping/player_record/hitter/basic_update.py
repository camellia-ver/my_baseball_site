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
        sql = "update player_hitter_record_basic set "+\
            "phrb_AVG = '"+data[1]+"', phrb_G = '"+data[2]+\
            "', phrb_PA = '"+data[3]+"', phrb_AB ='"+data[4]+\
            "', phrb_R = '"+data[5]+"', phrb_H = '"+data[6]+\
            "', phrb_2B = '"+data[7]+"', phrb_3B = '"+data[8]+\
            "', phrb_HR = '"+data[9]+"', phrb_TB = '"+data[10]+\
            "', phrb_RBI = '"+data[11]+"', phrb_SAC = '"+data[12]+\
            "', phrb_SF = '"+data[13]+"', phrb_BB = '"+data[14]+\
            "', phrb_IBB = '"+data[15]+"', phrb_HBP = '"+data[16]+\
            "', phrb_SO = '"+data[17]+"', phrb_GDP = '"+data[18]+\
            "', phrb_SLG = '"+data[19]+"', phrb_OBP = '"+data[20]+\
            "', phrb_OPS = '"+data[21]+"', phrb_MH = '"+data[22]+\
            "', phrb_RISP = '"+data[23]+"', phrb_PH_BA = '",\
            "' where phrb_year = '"+year+"' and phrb_player_name = '"+data[0]+"' and phrb_series = '" + series + "'"
        
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

now = datetime.datetime.now()
cur_year = now.year

select_position = {'포수':'2','내야수':'3,4,5,6','외야수':'7,8,9'}

for i in select_position.values():
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlPos_ddlPos"]')).select_by_value(i)
        
    time.sleep(10)
    getData("정규시즌",str(cur_year))

    prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpContent"]/div[2]/div[2]/a[1]')
    prev_btn.click()

db_connect.close()