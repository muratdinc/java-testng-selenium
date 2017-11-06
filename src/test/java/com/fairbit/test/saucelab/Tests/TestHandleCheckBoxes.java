package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.HandleCheckBoxes;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;


public class TestHandleCheckBoxes extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void VerifyHandleCheckBoxes(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Related pages...");
        HandleCheckBoxes page = HandleCheckBoxes.visitPage(driver);

        this.annotate("Checkbox ids ...");
        Assert.assertTrue(page.GetCheckBoxValues().equals("singcode"));
    }
}