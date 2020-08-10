package com.sevenwg.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSubmitPage extends BasePage {
    public OrderSubmitPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement GetOrderSubmitElement() {
        return GetElement("submit_order");
    }
}
