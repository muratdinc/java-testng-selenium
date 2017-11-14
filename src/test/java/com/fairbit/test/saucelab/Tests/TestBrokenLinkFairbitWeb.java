package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.BrokenLinkFairbitWeb;
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


public class TestBrokenLinkFairbitWeb extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyBrokenFairbitWeb(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Fairbit Web Page...");
        BrokenLinkFairbitWeb page = BrokenLinkFairbitWeb.visitPage(driver);

        this.annotate("Verifying Web Page...");
        page.VerifyLink();

        this.annotate("Verify Link Active ...");
        Assert.assertTrue(page.VerifyLink().equals("OK"));
    }
}