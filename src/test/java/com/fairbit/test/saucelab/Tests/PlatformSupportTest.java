package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.FairbitBasePagePlatformSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by OZGUR-FAIRBIT on 10/26/2017.
 */

public class PlatformSupportTest extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyDarkTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Fairbit page...");
        FairbitBasePagePlatformSupport page = FairbitBasePagePlatformSupport.visitPage(driver);

        this.annotate("Clicking Buton...");
        page.ClickButton();

        this.annotate("Control test is Nightmode ...");
        Assert.assertTrue(page.getLabelText().contains("dark"));

        //this.annotate("Login Fairbit page...");
        //page.LoginAndChangeMode();

        //this.annotate("Control Nightmode text...");
        //Assert.assertTrue(page.getLabelText().equals("Night Mode"));
    }
}