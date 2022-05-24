# KBO 순위 정보 수집
# 시범 경기 외의 정규리그 순위만 수집
# 1982 ~ 2021의 최종순위

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import Select
import requests
from bs4 import BeautifulSoup
import time

url = "https://www.koreabaseball.com/TeamRank/TeamRank.aspx"

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
# options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get(url)

response = requests.get(url)
html = response.text
soup = BeautifulSoup(html,'html.parser')

# 1999,2000 양대리그
for year in range(1999,2000):
    select = Select(driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_ddlYear"]')).select_by_value(str(year))
    time.sleep(1)
    if year == 1999 or year == 2000:
        # 드림리그
        tbody1 = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
        # 매직리그
        tbody2 = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_pnlMagicLeague"]/table/tbody').text
    else:
        tbody = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text
    time.sleep(1)
