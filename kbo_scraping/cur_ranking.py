# KBO 순위 정보 수집
# 시범 경기 외의 정규리그 순위만 수집
# 현시점의 순위를 수집

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import time

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/TeamRank/TeamRank.aspx")

tbody = driver.find_element_by_xpath('//*[@id="cphContents_cphContents_cphContents_udpRecord"]/table/tbody').text