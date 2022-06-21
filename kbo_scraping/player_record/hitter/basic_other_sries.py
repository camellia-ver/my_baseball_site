# 정규시즌 외의 타자 개인 기록 수집

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager
import pymysql
from pymysql import cursors
import time

def getData(series,year):
    pass

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Record/Player/HitterBasic/BasicOld.aspx?sort=HRA_RT")

select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlTeam_ddlTeam"]')).select_by_value("SS")
time.sleep(5)

select_position = {'포수':'2','내야수':'3,4,5,6','외야수':'7,8,9'}
select_series = {'와일드카드':'4','준플레이오프':'3','플레이오프':'5','한국시리즈':'7'}

for year in range(1982,2023):
    year = str(year)
    select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeason_ddlSeason"]')).select_by_value(year)

    time.sleep(5)

    for series,i in select_series.items():
        select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlSeries_ddlSeries"]')).select_by_value(i)
        for j in select_position.values():
            select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlPos_ddlPos"]')).select_by_value(j)
            time.sleep(10)
            getData(series,year)