package com.sevenwg.web.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseCase {

    public WebDriver driver;
    public WebDriver GetDriver(String browser) {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
            driver = new ChromeDriver();
        }else {
            /**
             * To be implemented
             */
        }
        return driver;
    }
}
