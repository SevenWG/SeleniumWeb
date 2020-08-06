package com.sevenwg.web.tutorials;

import com.sevenwg.web.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;


@Listeners({TestngListenerScreen.class})
public class OneTestCase {
    public WebDriver webDriver;

    @BeforeTest
    public void BeforeTest() {

    }

    @BeforeClass
    public void BeforeClass() {
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/weiwei/Downloads/chromedriver");
        this.webDriver = new ChromeDriver();
        webDriver.get("https://www.imooc.com/user/newlogin");
    }


    @Test
    public void LoginAction0() {
        ProUtil pro = new ProUtil("user.properties");

        String user;
        String userNameStr;
        String pwd;

        user = pro.GetProperties("user0");
        System.out.println(user);
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
        //this.TakeScreenShot();
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
            emailElement.clear();
            passwordElement.clear();
        }
    }

    @Test
    public void LoginAction1() {
        ProUtil pro = new ProUtil("user.properties");

        String user;
        String userNameStr;
        String pwd;

        user = pro.GetProperties("user1");
        System.out.println(user);
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
        //this.TakeScreenShot();
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
            emailElement.clear();
            passwordElement.clear();
        }
    }

    @Test
    public void LoginAction2() {
        ProUtil pro = new ProUtil("user.properties");

        String user;
        String userNameStr;
        String pwd;

        user = pro.GetProperties("user2");
        System.out.println(user);
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
        //this.TakeScreenShot();
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
            emailElement.clear();
            passwordElement.clear();
        }
    }

   /* @Test
    public void LoginAction() {
        ProUtil pro = new ProUtil("user.properties");
        int lines = pro.GetLines();

        String user;
        String userNameStr;
        String pwd;

        for(int i = 0; i < lines; i++) {
            user = pro.GetProperties("user" + i);
            System.out.println(user);
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
            this.TakeScreenShot();
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
                emailElement.clear();
                passwordElement.clear();
            }
        }
    }*/

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

    @AfterMethod
    public void AfterMethod() {

        webDriver.quit();
    }

    @AfterClass
    public void AfterClass() {
    }

    @AfterTest
    public void AfterTest() {

    }

    public String GetByLocator(String key) {
        ProUtil pro = new ProUtil("element.properties");
        return pro.GetProperties(key);
    }

    public WebElement GetElement(String key) {
        return webDriver.findElement(this.GetByLocal(key));
    }

/*    public void TakeScreenShot() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String currentDateTime = simpleDateFormat.format(new Date());
        String currentPath = System.getProperty("user.dir");
        String currentClass = this.getClass().getName();
        File ScrFile = ((RemoteWebDriver)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(ScrFile, new File(currentPath + "/" + currentClass + "_" + currentDateTime + ".png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
