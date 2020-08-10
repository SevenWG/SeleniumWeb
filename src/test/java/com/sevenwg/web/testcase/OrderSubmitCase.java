package com.sevenwg.web.testcase;

import com.sevenwg.web.handle.CourseHandle;
import com.sevenwg.web.handle.OrderSubmitHandle;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class OrderSubmitCase extends BaseCase{
    static Logger logger = Logger.getLogger(OrderSubmitCase.class);

    public WebDriver driver;
    public OrderSubmitHandle orderSubmitHandle;

    @Parameters({"url","browser"})
    @BeforeMethod
    public void beforeClass(String url,String browser) {
        PropertyConfigurator.configure("log4j.properties");

        logger.debug("Initializing Browser");
        logger.debug("Opening Browser");

        driver = GetDriver(browser);
        driver.get(url);

        orderSubmitHandle = new OrderSubmitHandle(driver);

    }

    @Parameters({"url"})
    @Test
    public void SubmitOrder(String url) {
        if(!orderSubmitHandle.IsUserLoggedIn()) {
            logger.debug("User has not logged in. Setting cookies now.");
            orderSubmitHandle.SetUserCookie();
        }

        driver.get(url);

        String submitTitle = orderSubmitHandle.GetTitle();
        boolean flag = submitTitle.contains("确认订单");
        Assert.assertTrue(flag);

        orderSubmitHandle.ClickOrderSubmitElement();
    }

    @Parameters({"url"})
    @Test
    public void SubmitOrderWithoutLoggingIn(String url) {
        driver.get(url);

        String submitTitle = orderSubmitHandle.GetTitle();

        System.out.println(submitTitle);

        boolean flag = submitTitle.contains("慕课网-登录");

        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void afterClass() {
        driver.close();
    }

}
