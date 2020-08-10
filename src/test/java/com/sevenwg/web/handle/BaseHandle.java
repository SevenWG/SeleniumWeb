package com.sevenwg.web.handle;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHandle {
    public WebDriver driver;
    public BaseHandle(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Inject Cookie
     * */
    public void  SetUserCookie() {
        String value = "I3NzA3ODc2ZDU4OTQ2MWVmNWQ3Mjk5MDEzY2IwYWUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMTM0NjY1MgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABqYWNvYi56aG91LmNhQGdtYWlsLmNvbQAAAAAAAAAAAGEwOTFlZTY3NTU5M2RjYzE1NGJkZDgxODJkMmNlZmZkOH0pXzC3OlU%3DOD";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
        driver.manage().addCookie(cookie);
    }



    public void ClearText(WebElement element) {
        /**
         * 		clear input
         * */
        element.clear();
    }

    /**
     * Get the title
     * */
    public String GetTitle() {
        return driver.getTitle();
    }

    public void ClickElement(WebElement element) {
        element.click();
    }
}
