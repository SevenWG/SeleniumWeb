package com.sevenwg.web.tutorials;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestngListenerScreen.class})
public class TestngCase {
    public WebDriver webDriver;
    @Test
    public void Test01() {
        Assert.assertEquals(1,2);
    }

    @Test
    public void Test02() {

    }

    @Test
    public void Test03() {

    }

    @Test
    public void Test04() {

    }

    @Test
    public void Test05() {

    }

}
