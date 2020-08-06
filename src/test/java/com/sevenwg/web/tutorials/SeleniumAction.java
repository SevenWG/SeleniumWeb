package com.sevenwg.web.tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumAction {
    public WebDriver webDriver;

    public void InitDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.imooc.com/");

        try {
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoginAction() {
        webDriver.findElement(By.id("js-signin-btn")).click();
/*
        try {
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }
*/

        this.PositiveWaite();
        WebElement emailElement = webDriver.findElement(By.name("email"));
        emailElement.sendKeys("jacob.zhou.ca@gmail.com");

        webDriver.findElement(By.className("js-loginPassword")).sendKeys("a123456a");
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //点击登录按钮
        webDriver.findElement(By.className("moco-btn-red")).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.navigate().refresh();
    }

    public void InputElement() {
        webDriver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        WebElement emailElement = webDriver.findElement(By.name("email"));
        emailElement.sendKeys("jacob.zhou.ca@gmail.com");
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        //emailElement.clear();
        String userInfo = emailElement.getAttribute("placeholder");
        System.out.println("Placeholder: " + userInfo);

        String email = emailElement.getAttribute("value");
        System.out.println("Email: " + email);

        boolean flag = emailElement.isEnabled();
        System.out.println("isEnabled: " + flag);

        webDriver.quit();
    }

    public void RadioAction() {
        this.LoginAction();

        //切换至个人信息页
        webDriver.get("https://www.imooc.com/user/setprofile");
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //编辑个人信息
        webDriver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //先找到用户信息表元素，再找到性别radio列表
        WebElement userForm = webDriver.findElement(By.id("profile"));
        List<WebElement> radios = userForm.findElements(By.name("sex"));

        for(WebElement sex : radios) {
            if(sex.isSelected()) {
                break;
            }
            else {
                sex.click();
            }
        }
        webDriver.quit();
    }

    public void CheckboxAction() {
        webDriver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        WebElement emailElement = webDriver.findElement(By.name("email"));
        emailElement.sendKeys("jacob.zhou.ca@gmail.com");

        webDriver.findElement(By.className("js-loginPassword")).sendKeys("a123456a");

        //找到自动登录checkbox
        WebElement box = webDriver.findElement(By.id("auto-signin"));

        //切换checkbox状态
        if(box.isSelected()) {
            System.out.println("Has been selected");
            box.click();
        }
        else {
            System.out.println("Has not been selected");
            box.click();
        }

        try {
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();

    }

    public void ButtonAction() {
        webDriver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //通过执行js命令，隐藏登录按钮
        String jsCommand = "document.getElementsByClassName('moco-btn-red')[0].style.display = 'None'";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)webDriver;
        javascriptExecutor.executeScript(jsCommand);

        //按钮存在 但是未显示
        WebElement button = webDriver.findElement(By.className("moco-btn-red"));
        System.out.println(button.isEnabled());
        System.out.println(button.isDisplayed());
        webDriver.quit();

    }

    public void UploadAction() {
        this.LoginAction();

        webDriver.get("https://www.imooc.com/user/setbindsns");
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        WebElement headPng = webDriver.findElement(By.className("avator-mode"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(headPng).perform();

        webDriver.findElement(By.className("js-avator-link")).click();
        webDriver.findElement(By.id("upload")).sendKeys("/Users/weiwei/Downloads/test.jpg");
        System.out.println("Avator uploaded");

        try {
            Thread.sleep(5000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    public void WebFormAction() {
        webDriver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[1]/input")).sendKeys("jacob.zhou.ca@gmail.com");
        webDriver.findElement(By.className("js-loginPassword")).sendKeys("a123456a");
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.id("signup-form")).submit();
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectAction() {
        this.LoginAction();

        //切换至个人信息页
        webDriver.get("https://www.imooc.com/user/setprofile");
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //编辑个人信息
        webDriver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //先找到用户信息表元素
        WebElement userForm = webDriver.findElement(By.id("profile"));

        userForm.findElement(By.id("job")).click();
        List<WebElement> options = userForm.findElements(By.tagName("option"));
        options.get(5).click();

        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    public void SelectActionOne() {
        this.LoginAction();

        //切换至个人信息页
        webDriver.get("https://www.imooc.com/user/setprofile");
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        //编辑个人信息
        webDriver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        WebElement userForm = webDriver.findElement(By.id("profile"));

        WebElement jobSelectList = userForm.findElement(By.id("job"));

        Select downList = new Select(jobSelectList);

        //三种不同方法
        downList.selectByIndex(8);
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        downList.selectByValue("10");
        try {
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        downList.selectByVisibleText("学生");
        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        List<WebElement> options = downList.getAllSelectedOptions();
        for(WebElement option: options) {
            System.out.println(option.getText());
        }
        webDriver.quit();
    }

    public void MouseAction() {
        WebElement loginElement = webDriver.findElement(By.id("js-signin-btn"));
        Actions actions = new Actions(webDriver);
        actions.click(loginElement).perform();

        List<WebElement> menuElement = webDriver.findElements(By.className("item"));
        WebElement frontendOption = menuElement.get(1);

        actions.moveToElement(frontendOption).perform();
        webDriver.findElement(By.linkText("小程序")).click();
        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    //重点！！！
    public void switchIframe() {
        this.LoginAction();

        //获取iframe
        webDriver.get("https://www.imooc.com/article/publish#");
        WebElement iframeElement = webDriver.findElement(By.id("ueditor_0"));

        //切换至iframe
        webDriver.switchTo().frame(iframeElement);
        //找到iframe里面的文本框
        WebElement uEditor = webDriver.findElement(By.tagName("p"));

        Actions actions = new Actions(webDriver);

        /*
        两种方法都能实现在iframe里的操作
        */
        //actions.moveToElement(uEditor).click().sendKeys("It works!").perform();
        actions.click(uEditor);
        uEditor.sendKeys("It works!");

        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    public void multipleWindowsAction() {
        WebElement loginElement = webDriver.findElement(By.id("js-signin-btn"));
        Actions actions = new Actions(webDriver);
        actions.click(loginElement).perform();

        List<WebElement> menuElement = webDriver.findElements(By.className("item"));
        WebElement frontendOption = menuElement.get(1);

        actions.moveToElement(frontendOption).perform();
        webDriver.findElement(By.linkText("小程序")).click();
        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        Set<String> Handles = webDriver.getWindowHandles();
        String currentHandle = webDriver.getWindowHandle();
        for(String s: Handles) {
            System.out.println(s);
            if(s.equals(currentHandle)) {
            }else {
                webDriver.switchTo().window(s);
            }
        }

        webDriver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[2]/a/div/div/div[2]/p[1]")).click();
        try {
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    //隐式等待
    public void NegativeWait() {

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //显示等待
    public void PositiveWaite() {
        /*WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));*/
    }

    public static void main(String[] args) {
        SeleniumAction seleniumAction = new SeleniumAction();
        seleniumAction.InitDriver();
        //seleniumAction.LoginAction();
        //seleniumAction.InputElement();
        //seleniumAction.RadioAction();
        //seleniumAction.CheckboxAction();
        //seleniumAction.ButtonAction();
        //seleniumAction.UploadAction();
        //seleniumAction.WebFormAction();
        //seleniumAction.MouseAction();
        seleniumAction.switchIframe();
        //seleniumAction.multipleWindowsAction();
    }

}
