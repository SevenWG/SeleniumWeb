package com.sevenwg.web.testcase;

import com.sevenwg.web.handle.LoginHandle;
import com.sevenwg.web.tutorials.TestngListenerScreen;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestngListenerScreen.class})
public class LoginCase extends BaseCase{
    public WebDriver webDriver;
    public LoginHandle loginHandle;

    public static Logger logger = Logger.getLogger(LoginCase.class);

    @Parameters({"url", "browser"})
    @BeforeMethod
    public void BeforeMethod(String url, String browser) {
        PropertyConfigurator.configure("log4j.properties");

        this.webDriver = this.GetDriver(browser);

        logger.debug("Open Web Browser");

        //this.webDriver = new ChromeDriver();
        this.webDriver.get(url);

        try {
            Thread.sleep(2000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        this.loginHandle = new LoginHandle(webDriver);

    }

    @Parameters({"username", "password"})
    @Test
    public void LoginSuccessTest(String username, String password) {
        this.loginHandle.InputEmail(username);
        this.loginHandle.InputPassword(password);
        this.loginHandle.ClickLoginButton();

        String userNameText = this.loginHandle.GetUserNameText();
        Assert.assertEquals(userNameText, "jacobzhou");
    }

    @Test
    public void LoginEmailError() {
        this.loginHandle.InputEmail("weiw4180@gmail.com");
        this.loginHandle.InputPassword("a123456a");
        this.loginHandle.ClickLoginButton();
    }

    @AfterMethod
    public void AfterMethod() {
        webDriver.close();
    }
}
