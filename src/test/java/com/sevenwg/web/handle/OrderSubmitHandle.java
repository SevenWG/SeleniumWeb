package com.sevenwg.web.handle;

import com.sevenwg.web.page.OrderSubmitPage;
import org.openqa.selenium.WebDriver;

public class OrderSubmitHandle extends BaseHandle {

    public OrderSubmitPage orderSubmitPage;
    public WebDriver webDriver;

    public OrderSubmitHandle(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.orderSubmitPage = new OrderSubmitPage(driver);
    }

    public void ClickOrderSubmitElement() {
        ClickElement(this.orderSubmitPage.GetOrderSubmitElement());
    }

    public boolean IsUserLoggedIn() {
        return orderSubmitPage.GetUserIsLogin();
    }
}
