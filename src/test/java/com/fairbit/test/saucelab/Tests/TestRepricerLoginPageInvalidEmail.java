package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.RepricerLoginPageInvalidEmail;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

public class TestRepricerLoginPageInvalidEmail extends TestBase {
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyRepricerLoginPageInvalidEmail(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException, InterruptedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Repricer login page...");
        RepricerLoginPageInvalidEmail page = RepricerLoginPageInvalidEmail.visitPage(driver);

        this.annotate("Clicking login...");
        page.login();

        this.annotate("Control test is invalid ...");
        Thread.sleep(1000);
        Assert.assertTrue(page.getLabelText().equals("Wrong email or password. Try again."));
    }

}
