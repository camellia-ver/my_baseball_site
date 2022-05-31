# 경기 결과 수집
# 정규시즌 내용 만
# 지난 시즌
# ~ 2021까지 더블헤더 존재

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

select = Select(driver.find_element_by_xpath('//*[@id="ddlMonth"]')).select_by_value("04")
team_btn = driver.find_element_by_xpath('//*[@id="contents"]/ul/li[4]/a')
team_btn.click()
next_btn = driver.find_element_by_xpath('//*[@id="btnNext"]/img')

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

for year in range(2001,2022):
    year = str(year)
    select = Select(driver.find_element_by_xpath('//*[@id="ddlYear"]')).select_by_value(year)
    select = Select(driver.find_element_by_xpath('//*[@id="ddlMonth"]')).select_by_value("04")
    while True:
        end_check = driver.find_element_by_xpath('//*[@id="tblSchedule"]/tbody/tr/td').text
        
        if end_check == "데이터가 없습니다.":
            break
        else:
            contents = driver.find_elements_by_xpath('//*[@id="tblSchedule"]/tbody/tr')
            date = ""
            for i in range(len(contents)):
                result = contents[i].text.split(' ')
                
                if i > 0:
                    date = contents[i-1].text.split(' ')[0]
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
                    if len(result[5]) > 2:
                        result[5] = result[5][-2:]
                    del result[4]
                    del result[3]
                    if date == "09.29(목)":
                        result.insert(0,date)
                        del result[3]
                elif len(result) == 6:
                    if len(result[4]) > 2:
                        result[4] = result[4][-2:]
                    del result[3]
                elif len(result) == 5:
                    if len(result[3]) > 2:
                        result[3] = result[3][-2:]
                    else:
                        del result[2]
                        result.insert(0,date)
                elif len(result) == 4:
                    result.insert(3,result[2][-2:])
                    result[2] = result[2][:6]
                
                ssg_idx = result[2].find("SSG")
                kia_idx = result[2].find("KIA")
                hero_idx = result[2].find("히어로즈")
                if kia_idx == -1 and ssg_idx == -1 and hero_idx == -1:
                    result.insert(3,result[2][:2])
                    result.insert(4,result[2][2:-2])
                    result.insert(5,result[2][-2:])
                else:
                    if hero_idx == 0 :
                        result.insert(3,result[2][:4])
                        result.insert(4,result[2][4:-2])
                        result.insert(5,result[2][-2:])
                    elif hero_idx > 5:
                        result.insert(3,result[2][:2])
                        result.insert(4,result[2][2:-4])
                        result.insert(5,result[2][-4:])
                    elif ssg_idx == 0 or kia_idx == 0:
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
                save_data = "'" + "','".join(result) + "'" + ",'정규시즌'"
                save_data = save_data[1:9]+save_data[10:]
                
                sql = "insert into schedule_game_result(g_date,g_time,team1,team1_score,team2_score,team2,baseball_stadium,note,season)values(" + save_data + ')'
                try:
                    cursor.execute(sql)
                    db_connect.commit()
                except:
                    print(save_data)

        next_btn.click()

        time.sleep(5)

db_connect.close()