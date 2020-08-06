package com.sevenwg.web.tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumOne {
    public WebDriver webDriver;

    public void InitDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.imooc.com/");

        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void GetElement() {
        webDriver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.name("email")).sendKeys("jacob.zhou.ca@gmail.com");
        webDriver.findElement(By.className("js-loginPassword")).sendKeys("a123456");
        WebElement node = webDriver.findElement(By.className("rlf-autoin"));
        node.findElement(By.tagName("input"));
        List<WebElement> buttonElements = webDriver.findElements(By.className("rlf-group"));
        buttonElements.get(4).click();
        webDriver.findElement(By.linkText("找回密码")).click();
        webDriver.findElement(By.partialLinkText("无法")).click();
        webDriver.findElement(By.xpath("//*[@id=\"signin\"]/div[3]/div[1]/span")).click();//手机短信登录
        webDriver.findElement(By.cssSelector("#signup-form > div.rlf-group.pr.phoneVerityBox > p.reSend.pa.active.js-phonecode-box > span")).click();//获取验证码
        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.close();
    }

    public static void main(String[] args) {
        SeleniumOne seleniumOne = new SeleniumOne();

        seleniumOne.InitDriver();

        seleniumOne.GetElement();
    }

}
