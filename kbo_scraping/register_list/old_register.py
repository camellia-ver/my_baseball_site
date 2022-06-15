# 2022 ~ yesterday 선수등록 현황 수집

from numpy import insert
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import cursors
import time

def create_datas(scraping_data,date,position,is_regist):
    date = date.replace('.','')

    for data in scraping_data:
        data = data.text.split(' ')

        if data[0] == "당일":
            return

        try:
            check = int(data[0])
        except:
            data.insert(0,'-1')

        if len(data) == 7:
            position = data[2]
            del data[2]

        data[3] = data[3].replace('-','')
        data[4] = data[4][:-3]
        data[5] = data[5][:-2]
        data.append(date)

        save_data = "'" + "','".join(data) + "','" + position + "','" + is_regist + "'"
        
        sql = "insert into register(rg_back_number,rg_name,rg_p_b_type,rg_brith,rg_height,rg_weight,rg_date,rg_position,is_regist)values(" + save_data + ')'
            
        cursor.execute(sql)
        db_connect.commit()

def create_data(data,date):
    date = date.replace('.','')

    data = data.text.split(' ')

    if data[0] == "당일":
        return

    data[3] = data[3].replace('-','')
    data[4] = data[4][:-3]
    data[5] = data[5][:-2]
    data.append(date)

    save_manager = "'" + "','".join(data) + "','감독',''"

    sql = "insert into register(rg_back_number,rg_name,rg_p_b_type,rg_brith,rg_height,rg_weight,rg_date,rg_position,is_regist)values(" + save_manager + ')'
            
    cursor.execute(sql)
    db_connect.commit()

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

while(date != '2022.04.02'):
    prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_btnPreDate"]/img')
    prev_btn.click()
    
    time.sleep(5)

    date = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_lblGameDate"]').text
    date = date[:-3]

    manager = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[1]/tbody/tr')
    create_data(manager,date)

    coachs = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[2]/tbody/tr')
    create_datas(coachs,date,"코치",'')

    p_player = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[3]/tbody/tr')
    create_datas(p_player,date,"투수",'')
    c_player = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[4]/tbody/tr')
    create_datas(c_player,date,"포수",'')
    if_player = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[5]/tbody/tr')
    create_datas(if_player,date,"내야수",'')
    of_player = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[3]/table[6]/tbody/tr')
    create_datas(of_player,date,"외야수",'')

    regist_player = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[4]/table[1]/tbody/tr')
    create_datas(regist_player,date,'',"등록")
    out_register_player = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[4]/table[2]/tbody/tr')
    create_datas(out_register_player,date,'',"말소")

    time.sleep(5)

db_connect.close()