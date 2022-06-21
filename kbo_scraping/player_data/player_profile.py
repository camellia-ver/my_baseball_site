# 선수들의 기본적인 프로필 수집

from fileinput import filename
from unittest import result
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager
import requests
from bs4 import BeautifulSoup
import pymysql
from pymysql import cursors
import datetime

def save_profile(img,name,backnumber,birth,position,height_weight,career,payment,salary,draft,join):
    now = datetime.datetime.now()
    create_date = str(now.date()).replace('-','')
    
    data = []
    
    birth = birth[:4] + birth[6:8] + birth[10:-1]
    position = position.split('(')
    position[1] = position[1][:-1]
    height = height_weight[:3]
    weight = height_weight[-4:-2]
    if payment != '':
        payment = payment[:-2]
    else:
        payment = '-1'
    salary = salary[:-2]

    img_file_name = birth + '_' + position[1] + '_' + name

    image_res = requests.get(img)
    image_res.raise_for_status()

    image_url = r"C:\Users\jyr\Desktop\study\portfolio\image\players_img\{}.jpg".format(img_file_name)
        
    with open(image_url,"wb") as f:
        f.write(image_res.content)

    data.append(name)
    data.append(backnumber)
    data.append(birth)
    data.extend(position)
    data.append(height)
    data.append(weight)
    data.append(career)
    data.append(payment)
    data.append(salary)
    data.append(draft)
    data.append(join)
    data.append(image_url)
    data.append(create_date)

    save_data = "'" + "','".join(data) + "'"

    sql = "insert into player_profile(name,backnumber,birth,position1,position2,height,weight,career,payment,salary,draft,join_year,image_url,create_date)values(" + save_data + ')'
            
    cursor.execute(sql)
    db_connect.commit()

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

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

with open(r"C:\Users\jyr\Desktop\study\portfolio\my_baseball_site\kbo_scraping\player_data\players_url\player_data_url.csv","r") as f:
    urls = f.readlines()

for url in urls:
    url = url.replace('\n','')
    url = url.split(',')
    
    driver.implicitly_wait(5)
    driver.get(url[0])

    if(url[1] == '2군'):
        img = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_imgProfile"]').get_attribute('src')
        name = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblName"]').text
        backnumber = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblBackNo"]').text
        birth = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblBirthday"]').text
        position = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblPosition"]').text
        height_weight = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblHeightWeight"]').text
        career = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblCareer"]').text
        payment = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblPayment"]').text
        salary = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblSalary"]').text
        draft = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblDraft"]').text
        join = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ucPlayerProfile_lblJoinInfo"]').text

        save_profile(img,name,backnumber,birth,position,height_weight,career,payment,salary,draft,join)
    else:
        img = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_imgProgile"]').get_attribute('src')
        name = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblName"]').text
        backnumber = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblBackNo"]').text
        birth = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblBirthday"]').text
        position = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblPosition"]').text
        height_weight = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblHeightWeight"]').text
        career = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblCareer"]').text
        payment = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblPayment"]').text
        salary = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblSalary"]').text
        nomination_ranking = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblDraft"]').text
        join = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_playerProfile_lblJoinInfo"]').text

        save_profile(img,name,backnumber,birth,position,height_weight,career,payment,salary,draft,join)
        
db_connect.close()