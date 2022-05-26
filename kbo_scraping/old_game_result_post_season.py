# 경기 결과 수집
# 포스트시즌 내용 만(2010이후 부터 데이터 존재)
# 지난 시즌

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
driver.get("https://www.koreabaseball.com/Schedule/Schedule.aspx")

select = Select(driver.find_element_by_xpath('//*[@id="ddlSeries"]')).select_by_value("3,4,5,7")

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

for year in range(2010,2022):
    year = str(year)
    select = Select(driver.find_element_by_xpath('//*[@id="ddlYear"]')).select_by_value(str(year))

    contents = driver.find_elements_by_xpath('//*[@id="tblSchedule"]/tbody/tr')

    for i in contents:
        result = i.text.split(' ')

        if result[1] == "이동일":
            continue

        print(result)
        if len(result) == 9:
            del result[6]
            del result[5]
            del result[4]
            del result[3]
        elif len(result) == 8:
            del result[5]
            del result[4]
            del result[3]
        elif len(result) == 7:
            del result[4]
            del result[3]
        elif len(result) == 6:
            result[4] = result[4][-2:]
            del result[3]
        elif len(result) == 4:
            result.append("-")

        ssg_idx = result[2].find("SSG")
        kia_idx = result[2].find("KIA")
        if kia_idx == -1 and ssg_idx == -1:
            result.insert(3,result[2][:2])
            result.insert(4,result[2][2:-2])
            result.insert(5,result[2][-2:])
        else:
            if ssg_idx == 0 or kia_idx == 0:
                result.insert(3,result[2][:3])
                result.insert(4,result[2][3:-2])
                result.insert(5,result[2][-2:])
            else:
                result.insert(3,result[2][:2])
                result.insert(4,result[2][2:-3])
                result.insert(5,result[2][-3:])
        del result[2]

        vs_idx = result[3].find("vs")
        if result[3][:vs_idx] == '':
                    result.insert(4,'-1')
                    result.insert(5,'-1')
        else:
            result.insert(4,result[3][:vs_idx])
            result.insert(5,result[3][vs_idx+2:])
        del result[3]

        result[0] = year + result[0][:2] + result[0][3:5]
        save_data = "'" + "','".join(result) + "'" + ",'포스트시즌'"
        save_data = save_data[1:9]+save_data[10:]

        sql = "insert into schedule_game_result(g_date,g_time,team1,team1_score,team2_score,team2,baseball_stadium,note,season)values(" + save_data + ')'
        print(sql)      
        cursor.execute(sql)
        db_connect.commit()
    
    time.sleep(5)

db_connect.close()