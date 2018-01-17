package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.RepricerLoginPageGoogleSignIn;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

public class TestRepricerLoginPageGoogleSignIn extends TestBase {
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyRepricerLoginPageGoogleSignIn(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException, InterruptedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Repricer login page...");
        RepricerLoginPageGoogleSignIn page = RepricerLoginPageGoogleSignIn.visitPage(driver);

        this.annotate("Clicking google sign in link...");
        page.login();

        this.annotate("Control google sign in...");
        Thread.sleep(1000);
        Assert.assertTrue(page.getLabelText().equals("to continue to auth0.com"));
    }

}

