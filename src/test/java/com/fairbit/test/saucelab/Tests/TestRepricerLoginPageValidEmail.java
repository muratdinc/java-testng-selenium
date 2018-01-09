package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.RepricerLoginPageValidEmail;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by OZGUR-FAIRBIT on 11/3/2017.
 */


public class TestRepricerLoginPageValidEmail extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyRepricerLoginPageValidEmail(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException, InterruptedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Repricer login page...");
        RepricerLoginPageValidEmail page = RepricerLoginPageValidEmail.visitPage(driver);

        this.annotate("Clicking login...");
        page.login();

        this.annotate("Control test is good or not ...");
    Thread.sleep(1000);
        Assert.assertTrue(page.getLabelText().equals("fairbit"));
    }
}