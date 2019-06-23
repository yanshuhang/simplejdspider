package com.ysh.simplejdspider.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {
    public static WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "d:/seleniumdriver/chromedriver.exe");
        return new ChromeDriver();
    }
}
