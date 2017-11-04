package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.DropdownSelectionFacebook;
import com.fairbit.test.saucelab.Pages.GitHubRegistration;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;



public class TestDropdownSelectionFacebook extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void VerifyDropdownSelectionFacebook(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting Facebook login page...");
        DropdownSelectionFacebook page = DropdownSelectionFacebook.visitPage(driver);

        this.annotate("Dropdown month value ...");
        Assert.assertTrue(page.GetSelectDDValues().equals("Aug"));
    }
}