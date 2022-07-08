package com.ti.testcases;

import com.ti.base.BrowserType;
import com.ti.base.DriverFactory;
import com.ti.pages.FeedbackPage;
import com.ti.pages.MainPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseTestClass {
    String baseURL = "http://zero.webappsecurity.com/";
    Map<String, String> inputData = new HashMap<>();
    MainPage mainPage;
    FeedbackPage feedbackPage;

    @BeforeTest
    @Parameters("browser")
     void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser.toUpperCase()));
        DriverFactory.getInstance().getDriver().navigate().to(baseURL);

        inputData.put("name", "test");
        inputData.put("email", "test@test.com");
        inputData.put("invalidEmail", "testtest.com");
        inputData.put("subject", "Subject");
        inputData.put("comment", "Commentary");
        inputData.put("blankSpace", " ");
        inputData.put("specialCharacters", "!#$%&/()");

        mainPage = new MainPage();
        feedbackPage = new FeedbackPage();
    }

    @AfterTest
    void turnDown(){
        DriverFactory.getInstance().removeDriver();
    }
}
