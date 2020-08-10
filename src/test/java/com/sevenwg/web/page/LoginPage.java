package com.sevenwg.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement GetEmailElement() {
        return this.GetElement("username");
    }

    public WebElement GetPasswordElement() {
        return this.GetElement("password");
    }

    public WebElement GetLoginBtnElement() {
        return this.GetElement("loginbutton");
    }

    public WebElement GetAvatorElement() {
        return this.GetElement("headpng");
    }

    public WebElement GetUserNameElement() {
        return this.GetElement("userinfo");
    }
}
