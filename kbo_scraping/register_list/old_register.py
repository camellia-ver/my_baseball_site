# 2022 ~ yesterday 선수등록 현황 수집

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
driver.get("https://www.koreabaseball.com/Player/Register.aspx")

team = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[1]/ul/li[5]/a')
team.click()

time.sleep(5)

date = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_lblGameDate"]').text
date = date[:-3]

while(date != '2022.04.02'):
    prev_btn = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_btnPreDate"]/img')
    prev_btn.click()

    date = driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_lblGameDate"]').text
    date = date[:-3]
    
    time.sleep(5)