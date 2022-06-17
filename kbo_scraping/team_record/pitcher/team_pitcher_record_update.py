# 올해 팀 기록 업데이트
# 투수 기록, 정규리그 기록만 수집

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
        if len(content) == 19:
            content[9] = content[9] + ' ' + content[10]
            del content[10]
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
        sql = "update team_pitcher_record set "\
        + "tpr_ERA = '"+data[1]+"', tpr_G = '"+data[2]\
        +"', tpr_W = '"+data[3]+"', tpr_L = '"+data[4]\
        +"', tpr_SV = '"+data[5]+"', tpr_HLD = '"+data[6]\
        +"', tpr_WPCT = '"+data[7]+"', tpr_IP = '"+data[8]\
        +"', tpr_H = '"+data[9]+"', tpr_HR = '"+data[10]\
        +"', tpr_BB = '"+data[11]+"', tpr_HBP = '"+data[12]\
        +"', tpr_SO = '"+data[13]+"', tpr_R = '"+data[14]\
        +"', tpr_ER = '"+data[15]+"', tpr_WHIP = '"+data[16]\
        +"', tpr_CG = '"+data[17]+"', tpr_SHO = '"+data[18]\
        +"', tpr_QS = '"+data[19]+"', tpr_BSV = '"+data[20]\
        +"', tpr_TBF = '"+data[21]+"', tpr_NP = '"+data[22]\
        +"', tpr_AVG = '"+data[23]+"', tpr_2B = '"+data[24]\
        +"', tpr_3B = '"+data[25]+"', tpr_SAC = '"+data[26]\
        +"', tpr_SF = '"+data[27]+"', tpr_IBB = '"+data[28]\
        +"', tpr_WP = '"+data[29]+"', tpr_BK = '"+data[30]\
        +"' where tpr_team_name = '" + data[0] + "' and tpr_year = '" + year + "'"
        
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

now = datetime.datetime.now()
cur_year = now.year

time.sleep(5)
data = getData("정규시즌",str(cur_year))

# select_series = {'와일드카드':4,'준플레이오프':3,'플레이오프':5,'한국시리즈':7}
    
# for series,i in select_series.items():
#     select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeries_ddlSeries"]')).select_by_value(str(i))
#     time.sleep(5)
#     getData(series,cur_year)

db_connect.close()