# 경기 결과 수집
# 정규시즌 내용 만
# 현재 시즌
# 2022년 부터 더블헤더 폐지

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

while True:
    end_check = driver.find_element_by_xpath('//*[@id="tblSchedule"]/tbody/tr/td').text
    
    if end_check == "데이터가 없습니다.":
        break
    else:
        contents = driver.find_elements_by_xpath('//*[@id="tblSchedule"]/tbody/tr')

        for i in contents:
            result = i.text.split(' ')
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
            print(result)
            
    next_btn.click()

    time.sleep(5)