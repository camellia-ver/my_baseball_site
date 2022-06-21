# 선수 개인 페이지 url 수집
# 파일로 저장
# 일주일 주기로 업데이트?

from unittest import result
from certifi import contents
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager
import time

options = Options()
options.add_experimental_option("detach",True)
options.add_experimental_option("excludeSwitches",["enable-logging"])
options.add_argument("headless")

service = Service(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service,options=options)

driver.implicitly_wait(5)
driver.get("https://www.koreabaseball.com/Player/Search.aspx")

select = Select(driver.find_element(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_ddlTeam"]')).select_by_value('SS')
time.sleep(5)

f = open(r"C:\Users\jyr\Desktop\study\portfolio\my_baseball_site\kbo_scraping\player_data\players_url\player_data_url.csv","w")

# 페이지 변화 (1~5)
page_num = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[2]/div/a')
for i in range(len(page_num)-2):
    paging = driver.find_element(by=By.XPATH,value=f'//*[@id="cphContents_cphContents_cphContents_ucPager_btnNo{i+1}"]')
    paging.click()
    time.sleep(5)

    contents = driver.find_elements(by=By.XPATH,value='//*[@id="cphContents_cphContents_cphContents_udpRecord"]/div[2]/table/tbody/tr/td/a')
    
    for content in contents:
        url = content.get_attribute('href')
        
        if "Futures" in url:
            f.write(f"{url},2군\n")
        else:
            f.write(f"{url},1군\n")