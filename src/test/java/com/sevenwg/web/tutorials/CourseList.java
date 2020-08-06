package com.sevenwg.web.tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseList {
    public WebDriver webDriver;

    @BeforeTest
    public void InitDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
        this.webDriver = new ChromeDriver();
        //webDriver.get("https://coding.imooc.com/");
        webDriver.get("https://coding.imooc.com/?c=java");
        //webDriver.get("https://coding.imooc.com/?c=net");
    }

    @Test
    public void CourseListValidation() {
        List<Integer> pageNumlist = this.GetPageNum();
        System.out.println(pageNumlist.size());
        for(int i = 0; i < pageNumlist.size() - 1; i++) {
            List<WebElement> webElements = webDriver.findElements(By.className("shizan-name"));
            for(int j = 0; j < webElements.size(); j++) {
                System.out.println(webElements.get(j).getText());
                webElements.get(j).click();
                webDriver.navigate().back();
                webElements = webDriver.findElements(By.className("shizan-name"));
                try {
                    Thread.sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                webDriver.findElement(By.linkText("下一页")).click();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void CourseListValidation01() {
        try {
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        List<WebElement> webElements = webDriver.findElements(By.className("shizan-name"));
        System.out.println(webElements.size());
        for(int i = 0; i < webElements.size(); i++) {

            System.out.println(webElements.get(i).getText());

            webElements.get(i).click();
            webDriver.navigate().back();
            webElements = webDriver.findElements(By.className("shizan-name"));

            try {
                Thread.sleep(3000);
            }catch (Exception e) {
                e.printStackTrace();
            }

            if(i == webElements.size() - 1) {
                try {
                    WebElement pageDiv = webDriver.findElement(By.className("page"));
                    WebElement nextPageButton = pageDiv.findElement(By.linkText("下一页"));
                    nextPageButton.click();
                    this.CourseListValidation01();
                }catch (Exception e) {
                    break;
                }
            }
        }
    }

    @AfterTest
    public void QuitDriver() {
        webDriver.quit();
    }

    public List<Integer> GetPageNum() {
        List<Integer> pageNumList = new ArrayList<Integer>();
        List<WebElement> aElements = webDriver.findElement(By.className("page")).findElements(By.tagName("a"));
        for(WebElement aElement: aElements) {
            if(isNumber(aElement.getText())) {
                pageNumList.add(Integer.valueOf(aElement.getText()));
            }
        }
        return pageNumList;
    }

    public boolean isNumber(String pageNum) {
        Pattern pattern = Pattern.compile("^-?[0-9]\\d*$*");
        Matcher isNum = pattern.matcher(pageNum);
        if(isNum.matches())
            return true;
        else
            return false;
    }

}
