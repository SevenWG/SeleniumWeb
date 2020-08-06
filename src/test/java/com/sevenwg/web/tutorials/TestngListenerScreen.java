package com.sevenwg.web.tutorials;

import com.google.common.io.Files;
import com.sevenwg.web.testcase.LoginCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestngListenerScreen extends TestListenerAdapter {


    @Override
    public void onTestFailure(ITestResult tr){
        LoginCase tc = (LoginCase) tr.getInstance();
        this.TakeScreenShot(tc.webDriver);
        super.onTestFailure(tr);
    }

    public void TakeScreenShot(WebDriver webDriver) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

        String currentDateTime = simpleDateFormat.format(new Date());

        String currentPath = System.getProperty("user.dir");

        String currentClass = this.getClass().getName();

        String fileName = currentClass + "_" + currentDateTime + ".png";

        File ScrFile = ((RemoteWebDriver)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(ScrFile, new File(currentPath + "/" + fileName));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
