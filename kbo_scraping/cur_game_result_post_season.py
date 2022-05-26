# 경기 결과 수집
# 포스트시즌 내용 만
# 현재 시즌

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

contents = driver.find_elements_by_xpath('//*[@id="tblSchedule"]/tbody/tr')

year = "2022"
for i in contents:
    result = i.text.split(' ')
    if len(result) == 8:
            del result[5]
            del result[4]
            del result[3]
    elif len(result) == 7:
        del result[4]
        del result[3]
    elif len(result) == 6:
        result[4] = result[4][-2:]
        del result[3]

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
    result.insert(4,result[3][:vs_idx])
    result.insert(5,result[3][vs_idx+2:])
    del result[3]

    result[0] = year + result[0][:2] + result[0][3:5]
    save_data = "'" + "','".join(result) + "'" + '포스트시즌'