package com.sevenwg.web.handle;

import com.sevenwg.web.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHandle {

    public LoginPage loginPage;
    public static Logger logger = Logger.getLogger(LoginHandle.class);

    public LoginHandle(WebDriver webDriver) {
        this.loginPage = new LoginPage(webDriver);
    }

    public void InputEmail(String email) {
        logger.debug("User Email: " + email);
        this.loginPage.GetEmailElement().sendKeys(email);
    }

    public void InputPassword(String password) {
        logger.debug("User Password: " + password);
        this.loginPage.GetPasswordElement().sendKeys(password);
    }

    public void ClickLoginButton() {
        this.loginPage.GetLoginBtnElement().click();
    }

    public void ClearEmail() {
        this.loginPage.GetEmailElement().clear();
    }

    public void ClearPwd() {
        this.loginPage.GetPasswordElement().clear();
    }

    public String GetUserNameText() {
        WebElement avator = loginPage.GetAvatorElement();
        loginPage.MovetoElement(avator);
        String userNameText = loginPage.GetUserNameElement().getText();
        return userNameText;
    }
}
