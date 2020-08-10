package com.sevenwg.web.testcase;

import com.sevenwg.web.handle.CourseHandle;
import com.sevenwg.web.tutorials.TestngListenerScreen;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({TestngListenerScreen.class})
public class CourseCase extends BaseCase{
    static Logger logger = Logger.getLogger(CourseCase.class);

    public WebDriver driver;
    CourseHandle coursehandle;

    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url,String browser) {
        PropertyConfigurator.configure("log4j.properties");

        logger.debug("Initializing Browser");
        logger.debug("Opening Browser");

        driver = GetDriver(browser);
        driver.get(url);

        coursehandle = new CourseHandle(driver);

    }

    @Parameters({"coursename"})
    @Test
    public void TestAddCourseSuccess(String coursename) {


        if(!coursehandle.IsUserLoggedIn()) {
            logger.debug("User haven't logged in, setting user cookies now.");
            coursehandle.SetUserCookie();
        }


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.navigate().refresh();

        int a = 0;

        logger.debug("Starting Test Case - TestAddCourseSuccess");

        String course_title = coursehandle.GetTitle();

        boolean flag = course_title.contains(coursename);

        Assert.assertEquals(flag, true);

        int before_number = coursehandle.GetCartNum();

        coursehandle.ClickAddCart();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int after_number = coursehandle.GetCartNum();
        a = after_number-before_number;

        Assert.assertEquals(a, 1);
    }

    @Test
    public void TestAlreadyBuy() {
        logger.debug("Starting Test Case - TestAlreadyBuy");

        coursehandle.ClickAddCart();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        coursehandle.ClickCartSure();
    }

    @Test
    public void TestAlreadyLogin() {
        logger.debug("Starting Test Case - TestAlreadyLogin");

        if(!coursehandle.IsUserLoggedIn()) {
            logger.debug("User haven't logged in, setting user cookies now.");
            coursehandle.SetUserCookie();
        }
        else {
            logger.debug("User has alredy logged in.");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.navigate().refresh();

        //coursehandle.ClickAddCart();
        coursehandle.ClickBuyNow();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
