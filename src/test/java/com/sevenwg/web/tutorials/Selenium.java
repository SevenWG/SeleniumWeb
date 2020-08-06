package com.sevenwg.web.tutorials;

import com.sevenwg.web.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Selenium {
    public WebDriver webDriver;

    public void InitDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
        this.webDriver = new ChromeDriver();
        webDriver.get("https://www.imooc.com/user/newlogin");

        try {
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void LoginAction() {
        ProUtil pro = new ProUtil("user.properties");
        int lines = pro.GetLines();

        String user;
        String userNameStr;
        String pwd;

        for(int i = 0; i < lines; i++) {
            this.InitDriver();
            user = pro.GetProperties("user" + i);
            userNameStr = user.split(">")[0];
            pwd = user.split(">")[1];

            try {
                Thread.sleep(2000);
            }catch (Exception e) {
                e.printStackTrace();
            }

            WebElement emailElement = GetElement("username");
            WebElement passwordElement =GetElement("password");
            WebElement loginButton = GetElement("loginbutton");

            emailElement.sendKeys(userNameStr);
            passwordElement.sendKeys(pwd);

            //点击登录按钮
            loginButton.click();
            try {
                Thread.sleep(2000);
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                try {
                    Thread.sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                WebElement userAvator = GetElement("headpng");

                Actions actions = new Actions(webDriver);
                actions.moveToElement(userAvator).perform();

                String userName = GetElement("userinfo").getText();

                try {
                    Thread.sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }

                if(userName.equals("jacobzhou")) {
                    System.out.println("Login Success!");
                }
                else {
                    System.out.println("User info does not match!");
                }
            }
            catch (Exception e) {
                System.out.println("Login Failed!");
                e.printStackTrace();
            }finally {
                try {
                    Thread.sleep(5000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                webDriver.quit();
            }
        }
    }

    public By GetByLocal(String key) {
        String locator = this.GetByLocator(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
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

    public WebElement GetElement(String key) {
        return webDriver.findElement(this.GetByLocal(key));
    }

    public static void main(String[] args) {
        Selenium selenium = new Selenium();
        selenium.LoginAction();
    }
}
