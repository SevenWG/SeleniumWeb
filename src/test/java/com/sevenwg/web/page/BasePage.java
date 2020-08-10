package com.sevenwg.web.page;
import com.sevenwg.web.util.ProUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    public WebDriver webDriver;
    public static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public WebElement GetElement(String key) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(this.GetByLocal(key)));
        }
        catch (Exception e) {

        }
        return webDriver.findElement(this.GetByLocal(key));
    }

    public void MovetoElement(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
    }

    public By GetByLocal(String key) {
        logger.debug("Property Key is: " + key);
        String locator = this.GetByLocator(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        logger.debug("By locator is: " + locatorBy);
        logger.debug("By value is: " + locatorValue);
        if(locatorBy.equals("id")) {
            return By.id(locatorValue);
        }
        else if(locatorBy.equals("name")) {
            return By.name(locatorValue);
        }
        else if(locatorBy.equals("className")) {
            return By.className(locatorValue);
        }
        else {
            return By.xpath(locatorValue);
        }
    }

    public String GetByLocator(String key) {
        ProUtil pro = new ProUtil("element.properties");
        return pro.GetProperties(key);
    }

    public boolean GetCookie(String key) {
        boolean flag = false;
        Set<Cookie> cookies = webDriver.manage().getCookies();
        for(Cookie cookie:cookies) {
            if(cookie.getName().equals(key)) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean GetUserIsLogin() {
        return GetCookie("apsid");
    }
}
