package com.sevenwg.web.tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class localTest1 {
    public WebDriver webDriver;

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.imooc.com/");
        try {
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getElement() {
        webDriver.findElement(By.id("js-signin-btn")).click();
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
        WebDriver webDriver;
        webDriver = new ChromeDriver();

        webDriver.get("https://www.baidu.com/");
        //webDriver.findElement(By.id("kw")).sendKeys("selenium");
        //webDriver.findElement(By.name("wd")).sendKeys("selenium");
        //webDriver.findElement(By.className("s_ipt")).sendKeys("selenium");

        //webDriver.findElement(By.linkText("新闻")).click();
        //webDriver.findElement(By.partialLinkText("新")).click();

        //webDriver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("selenium");

        webDriver.findElement(By.cssSelector("#kw")).sendKeys("selenium");
    }
}
