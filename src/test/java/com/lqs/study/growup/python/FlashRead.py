import time

import requests
from selenium import webdriver


def refresh_html(jianshu_url):
    chromedriver = "C:\Program Files (x86)\Google\chromedriver_win32\chromedriver.exe"
    browser = webdriver.Chrome(chromedriver)
    browser.get(jianshu_url)
    while True:
        time.sleep(1)
        browser.refresh()

if __name__ == '__main__':
    url = 'https://www.toutiao.com/i6482646112527188494/'
    try:
        refresh_html(url)
    except:
        refresh_html(url)
