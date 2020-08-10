package com.sevenwg.web.handle;

import com.sevenwg.web.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHandle extends BaseHandle{

    public LoginPage loginPage;
    public static Logger logger = Logger.getLogger(LoginHandle.class);

    public LoginHandle(WebDriver driver) {
        super(driver);
        this.loginPage = new LoginPage(driver);
    }


    public void InputEmail(String email) {
        ClearText(this.loginPage.GetEmailElement());
        logger.debug("User Email: " + email);
        this.loginPage.GetEmailElement().sendKeys(email);
    }

    public void InputPassword(String password) {
        ClearText(this.loginPage.GetPasswordElement());
        logger.debug("User Password: " + password);
        this.loginPage.GetPasswordElement().sendKeys(password);
    }

    public void ClickLoginButton() {
        super.ClickElement(this.loginPage.GetLoginBtnElement());
    }

    public void ClearEmail() {
        super.ClearText(this.loginPage.GetEmailElement());
    }

    public void ClearPwd() {
        super.ClearText(this.loginPage.GetPasswordElement());
    }

    public String GetUserNameText() {
        WebElement avator = loginPage.GetAvatorElement();
        loginPage.MovetoElement(avator);
        String userNameText = loginPage.GetUserNameElement().getText();
        return userNameText;
    }
}
