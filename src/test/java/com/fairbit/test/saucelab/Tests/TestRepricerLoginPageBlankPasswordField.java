package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.RepricerLoginPageBlankPasswordField;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

public class TestRepricerLoginPageBlankPasswordField extends TestBase {
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyRepricerLoginPageBlankPasswordField(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException, InterruptedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Repricer login page...");
        RepricerLoginPageBlankPasswordField page = RepricerLoginPageBlankPasswordField.visitPage(driver);

        this.annotate("Clicking login...");
        page.login();

        this.annotate("Control test is invalid ...");
        Thread.sleep(1000);
        Assert.assertTrue(page.getLabelText().equals("Password field is required"));
    }

}

