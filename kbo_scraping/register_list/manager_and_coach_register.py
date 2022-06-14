# 감독과 코치진 등록현황 수집
# 보통 변경은 시즌이 끝나야지 이루어 지지만
# 드물게 시즌중에 변동이 있을 수 있음

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import cursors
import time,datetime

def create_data(arr,date):
    arr[3] = arr[3].replace('-','')
    arr[4] = arr[4][:-3]
    arr[5] = arr[5][:-2]
    arr.append(date)

    return arr


options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Player/Register.aspx")

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

team = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[1]/ul/li[6]/a')
team.click()

time.sleep(5)

date = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_lblGameDate"]').text
date = date[:-3]
date = date.replace('.','')

time.sleep(5)

manager = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[1]/tbody/tr').text
manager = manager.split(' ')
manager = create_data(manager,date)

save_manager = "'" + "','".join(manager) + "','감독',''"

sql = "insert into register(rg_back_number,rg_name,rg_p_b_type,rg_brith,rg_height,rg_weight,rg_date,rg_position,is_regist)values(" + save_manager + ')'
            
cursor.execute(sql)
db_connect.commit()

time.sleep(5)

coachs = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[2]/tbody/tr')
for coach in coachs:
    coach = coach.text.split(' ')
    coach = create_data(coach,date)

    save_coach = "'" + "','".join(coach) + "','코치',''"

    sql = "insert into register(rg_back_number,rg_name,rg_p_b_type,rg_brith,rg_height,rg_weight,rg_date,rg_position,is_regist)values(" + save_coach + ')'
            
    cursor.execute(sql)
    db_connect.commit()

db_connect.close()